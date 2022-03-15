package com.byeon.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.byeon.s1.board.BoardDTO;
import com.byeon.s1.board.BoardFileDTO;
import com.byeon.s1.board.BoardService;
import com.byeon.s1.util.FileManager;
import com.byeon.s1.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(qnaDAO.total(pager));
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.detail(boardDTO);
	}

//	오버라이딩은 상속받은 메서드를 재정의하는거라서 선언부는 상속받은 메서드와 동일해야한다
//	그래서 상속받은 board의 메서드에 추가를 해준다
	@Override
	public int add(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		//member와 동일하게 file저장을 하려면 먼저 add를 하고 이후에 파일 add가 가능
		//long num = qnaDAO.seqNum();
		//boardDTO.setNum(num);
		int result = qnaDAO.add(boardDTO);
		
		//1. HDD에 저장
		for(int i=0; i<files.length; i++) {//꼭 맨뒤에 /붙여줘야 폴더로 인식
			if(files[i].isEmpty()) {
			//files[i].getSize()==0
				continue;
			}
			String fileName = fileManager.save(files[i], "resources/upload/qna/");
			
		//2. DB에 저장(지역변수기 때문에 DB저장은 바로 해야한다)(멤버랑 다름)
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			//멤버부분과 다른것은 멤버의 id는 내가 입력한 값이고 qna의 num은 자동입력값!
			qnaFileDTO.setNum(boardDTO.getNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(files[i].getOriginalFilename());
			result = qnaDAO.addFile(qnaFileDTO);
		}
		
		return result;
	}


	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		//num으로 HDD에 저장된 파일명 조회
		List<BoardFileDTO> ar = qnaDAO.listFile(boardDTO);
		
		int result = qnaDAO.delete(boardDTO);
		
		if(result > 0) {
//			for(int i=0; i<ar.size(); i++) {
//				fileManager.remove("resources/upload/notice", null);
//			}
			//for(Collection에서 꺼낼타입명 변수명: Collection의 변수명){}
			for(BoardFileDTO dto: ar) {
				boolean check= fileManager.remove("resources/upload/qna", dto.getFileName());
//				if(check) {
//					
//				}else {}
			}
		}
		return result;
	}
	
	
	public int reply(QnaDTO qnaDTO) throws Exception{
		//qnaDTO.num      : 부모글의 글번호
		//qnaDTO.title    : 폼에서 입력한 답글 제목
		//qnaDTO.writer   : 폼에서 입력한 답글 작성자
		//qnaDTO.contents : 폼에서 입력한 답글 글내용
		//qnaDTO.regDate  : NULL (이유는 DTO에서 선언할때 Integer,
		//qnaDTO.hit      : NULL  Long 등 reference타입으로 선언해서 null)
		//qnaDTO.ref      : NULL
		//qnaDTO.step     : NULL
		//qnaDTO.depth    : NULL
		//1. 부모의 정보를 조회(ref, step, depth)
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		
		//2. 답글의 ref는 부모의 ref값
		qnaDTO.setRef(parent.getRef());
		
		//3. 답글의 step은 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		
		//4. 답글의 depth는 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);

		//qnaDTO.ref      : 부모의 ref
		//qnaDTO.step     : 부모의 step+1
		//qnaDTO.depth    : 부모의 depth+1
		
		//5. step update
		int result = qnaDAO.stepUpdate(parent);
		
		//6. 답글 insert
		result = qnaDAO.reply(qnaDTO);
		
		return result;
	}

	@Override
	public BoardFileDTO detailFile(BoardFileDTO boardFileDTO) throws Exception {
		return qnaDAO.detailFile(boardFileDTO);
	}
	


}

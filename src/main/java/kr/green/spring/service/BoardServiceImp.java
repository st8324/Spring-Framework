package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.vo.BoardVo;

@Service
public class BoardServiceImp implements 
	BoardService
{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVo> getBoardLists(Criteria cri,String search,Integer type) {
		if(search == null) {
			search="";
		}
		search = "%"+search+"%";
		//type에다 0이면 제목, 1이면 작성자, 2이면 내용이 되도록
		if(type == null) {
			type = 0;
		}
		if(type == 0)
			return boardDao.getBoardListsByTitle(cri,search);
		if(type == 1)
			return boardDao.getBoardListsByAuthor(cri,search);
		else
			return boardDao.getBoardListsByContents(cri,search);
	}

	@Override
	public void registerBoard(BoardVo boardVo) {
		boardDao.registerBoard(boardVo);
		
	}

	@Override
	public BoardVo getBoard(int num) {
		return boardDao.getBoard(num);
	}

	@Override
	public void deleteBoard(int num) {
		boardDao.deleteBoard(num);
	}

	@Override
	public void updateBoard(BoardVo boardVo) {
		boardDao.updateBoard(boardVo);
	}

	@Override
	public int getCountBoardLists(String search,Integer type) {
		if(type == 0)
			return boardDao.getCountBoardListsByTitle(search);
		if(type == 1)
			return boardDao.getCountBoardListsByAuthor(search);
		else
			return boardDao.getCountBoardListsByContents(search);
	}
	
	@Override
	public PageMaker getPageMaker(String search, Integer page, int perPageNum, int displayPageNum, Integer type) {
		if(search == null) {
			search="";
		}
		if(page == null)
			page = 1;
		if(type == null) {
			type = 0;
		}
		int totalCount = getCountBoardLists("%"+search+"%",type);//검색된 컨텐츠의 갯수를 가져와야함
		Criteria cri = new Criteria();
		cri.setPerPageNum(perPageNum);
		cri.setPage(page);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(cri);
		pageMaker.setDisplayPageNum(displayPageNum);
		pageMaker.setTotalCount(totalCount);
		return pageMaker;
	}
}






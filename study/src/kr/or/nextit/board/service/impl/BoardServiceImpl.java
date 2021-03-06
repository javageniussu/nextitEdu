package kr.or.nextit.board.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory; 

import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
import kr.or.nextit.jdbc.mybatisSqlSessionFactory;

public class BoardServiceImpl implements BoardService{
	
	private SqlSessionFactory sessionFactory = 
			mybatisSqlSessionFactory.getSqlSessionFactory();	//세션팩토리에서 마이바티스를이용하여 객체 생성
	
	private BoardMapper boardMapper; 
	
	@Override
	public boolean InsertboardItem(BoardVo boardVo) throws Exception {
		
		SqlSession session = null;
			
		try {
			
			boardVo.setSeqNo(UUID.randomUUID().toString());
			//boardVo.setServiceType("NOTICE");
			
			session = sessionFactory.openSession(); //디비에연결된 객체 가져옴
			boardMapper = session.getMapper(BoardMapper.class);
			boardMapper.insertBoardItem(boardVo);
			
			session.commit();
			
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo boardVo) throws Exception {
		
		SqlSession session = null;
		
		try {
			session = sessionFactory.openSession();
			
			boardMapper = session.getMapper(BoardMapper.class);
			
			//조회수 + 1 
			boardMapper.updateBoardCountItem(boardVo);
			
			List<BoardVo> result =  boardMapper.selectBoardList(boardVo);
			
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public BoardVo getBoardItem(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		
		SqlSession session = null;
		
		try {
			session= sessionFactory.openSession();
			boardMapper = session.getMapper(BoardMapper.class);
			
			//조회수 +1
			boardMapper.updateBoardCountItem(boardVo);
			
			BoardVo BoardResult = boardMapper.selectBoardItem(boardVo);
			
			session.commit();
			
			return BoardResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
			throw new Exception(e.getMessage(),e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public void deleteBoardItem(String seqNo) throws Exception {
		 
		SqlSession session = null;
		
		try {
			session = sessionFactory.openSession();
			
			boardMapper = session.getMapper(BoardMapper.class);
			boardMapper.deleteBoardItem(seqNo);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
			throw new Exception(e.getMessage(),e);
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public void updateBoardItem(BoardVo params) throws Exception {
		
		SqlSession conn = null;
		
		try {
			
			
			
			conn = sessionFactory.openSession();
			
			boardMapper = conn.getMapper(BoardMapper.class);
			boardMapper.updateBoardItem(params);
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
		} finally {
			 if(conn != null) {
				 conn.close();
			 }
		}
	}
}

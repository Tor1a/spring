package com.jjang051.model;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public int insertReply(ReplyDto replyDto) {
		int result =0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertReply",replyDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	public List<ReplyDto> getAllReply(int boardId) {
		List<ReplyDto> replyList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		replyList = sqlSession.selectList("getAllReply",boardId);
		sqlSession.close();
		
		return replyList;
	}
}

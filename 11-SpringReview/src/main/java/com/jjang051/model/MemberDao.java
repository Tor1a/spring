package com.jjang051.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // scan대상이 되고 spring container에 등록
public class MemberDao {
	// DB접속 Hi
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/jjang051/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<MemberDto> showAllMember() {
		List<MemberDto> memberList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		memberList = sqlSession.selectList("showAllMember");
		sqlSession.close();
		return memberList;
	}

	// board
	public MemberDto getSelectOne(int no) {
		MemberDto memberDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		memberDto = sqlSession.selectOne("getSelectOne", no);
		sqlSession.close();
		return memberDto;
	}

	public int insertMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertMember", memberDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public MemberDto getLoggedMember(MemberDto memberDto) {
		MemberDto loggedMember = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		loggedMember = sqlSession.selectOne("getLoggedMember", memberDto);
		sqlSession.close();
		return loggedMember;
	}

	public String getPassword(int no) {
		String password = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		password = sqlSession.selectOne("getPassword", no);
		sqlSession.close();
		return password;
	}

	public int deleteMember(int no) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteMember", no);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int modifyMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("modifyMember", memberDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	//unit, hika, upload
	public int idCheck(String id) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("idCheck", id);
		sqlSession.close();
		return result;
	}

}

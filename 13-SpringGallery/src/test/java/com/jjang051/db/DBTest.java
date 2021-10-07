package com.jjang051.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jjang051.config.RootAppContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootAppContext.class})
@Slf4j
public class DBTest {
	//메서드를 쓰고 테스트
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testSqlSessionFactory() {
		log.info("sqlSessionFactory == {}",sqlSessionFactory);
	}
} 	

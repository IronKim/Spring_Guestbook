package com.kmc.guestbook;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kmc.domain.BoardVO;
import com.kmc.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardDAOTest.class);
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("title입니다.");
		board.setContent("컨텐츠입니다.");
		board.setWriter("user00");
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception{
		logger.info(dao.read(5).toString());
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(5);
		board.setTitle("title입니다.2");
		board.setContent("컨텐츠입니다.2");
		dao.update(board);
	}

//	@Test
//	public void testDelete() throws Exception{
//		dao.delete(4);
//	}
}


package com.kmc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kmc.domain.Criteria;
import com.kmc.domain.ReplyVO;
import com.kmc.persistence.ReplyDAO;

@Repository
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	private ReplyDAO dao;

	@Override
	public void addReply(ReplyVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		dao.delete(rno);
	}

//	@Override
//	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int count(Integer bno) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
package com.kh.spring.notice.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.domain.PageInfo;
import com.kh.spring.notice.store.NoticeStore;
@Repository
public class NoticeStoreLogic implements NoticeStore{

	@Override
	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pi) {
		/*
		 * RowBounds : 쿼리문을 변경하지 않고도 페이징처리할 수 있게 해주는 클래스
		 * offset(변하는 값)과 limit(고정 값)을 이용해서 동작함
		 * offset값 - 건너 뛰어야 할 값 / limit값 - 한 페이지당 보여줄 게시물의 갯수
		 * ex) limit 10,  1~10,   0 : offset	←  currentPage
		 * 				 11~20,  10 : offset
		 * 				 21~30,  20 : offset
		 * currentPage값에 따라서 0, 10, 20으로 바뀌어야하는 offset을 구하는 식
		 * int offset = (currentPage - 1) * limit;
		 */
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage -1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}

	@Override
	public Notice selectOneById(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneById", noticeNo);
		return notice;
	}

	@Override
	public int getListCount(SqlSession session) {
		int result = session.selectOne("NoticeMapper.getListCount");
		return result;
	}

}

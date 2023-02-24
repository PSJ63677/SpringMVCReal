package com.kh.spring.notice.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.domain.PageInfo;
import com.kh.spring.notice.domain.Search;
import com.kh.spring.notice.service.NoticeService;
import com.kh.spring.notice.store.NoticeStore;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeStore nStore;
	@Autowired
	private SqlSession session;
		
	@Override
	public int insertNotice(Notice notice) {
		return nStore.insertNotice(session, notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		return nStore.updateNotice(session, notice);
	}

	@Override
	public int deleteNotice(int noticeNo) {
		int result = nStore.deleteNotice(session, noticeNo);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(PageInfo pi) {
		List<Notice> nList = nStore.selectNoticeList(session, pi);
		return nList;
	}

	@Override
	public Notice selectOneById(int noticeNo) {
		Notice notice = nStore.selectOneById(session, noticeNo);
		return notice;
	}

	@Override
	public List<Notice> selectListByKeyword(PageInfo pi, Search search) {
		List<Notice> searchList = nStore.selectListByKeyword(session, pi, search);
		return searchList;
	}

	@Override
	public int getListCount() {
		int result = nStore.getListCount(session);
		return result;
	}

	@Override
	public int getListCount(Search search) {
		int totalCount = nStore.getListCount(session, search);
		return totalCount;
	}

}

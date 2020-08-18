package com.beecode.interfaces;

import java.util.List;

import com.beecode.entity.TopNotice;

public interface TopNoticeService {
	
	public TopNotice createTopNotice(TopNotice topNotice);
	public TopNotice updateTopNotice(TopNotice topNotice);
	public TopNotice getTopNoticeById(Long id);
	public void deleteTopNotice(Long id);
	public List<TopNotice> getAllTopNotice();
	
}

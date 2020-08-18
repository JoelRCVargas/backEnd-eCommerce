package com.beecode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.TopNotice;
import com.beecode.interfaces.TopNoticeService;
import com.beecode.repository.ITopNoticeRepository;

@Service
public class TopNoticeServiceImpl implements TopNoticeService {
	
	@Autowired
	private ITopNoticeRepository topNoticeRepo;

	@Override
	public TopNotice createTopNotice(TopNotice topNotice) {
		return topNoticeRepo.save(topNotice);
	}

	@Override
	public TopNotice updateTopNotice(TopNotice topNotice) {
		return topNoticeRepo.save(topNotice);
	}

	@Override
	public TopNotice getTopNoticeById(Long id) {
		Optional<TopNotice> optionalTopNotice = topNoticeRepo.findById(id);
		if(optionalTopNotice.isPresent()) {
			return optionalTopNotice.get();
		}else {
			return null;
		}
	}

	@Override
	public void deleteTopNotice(Long id) {
		topNoticeRepo.deleteById(id);
	}

	@Override
	public List<TopNotice> getAllTopNotice() {
		return topNoticeRepo.findAll();
	}

}

package com.beecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.TopNotice;

public interface ITopNoticeRepository extends JpaRepository<TopNotice, Long> {

}

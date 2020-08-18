package com.beecode.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{
	
	public Set<Role> findByRoleName(String roleName);
	
}

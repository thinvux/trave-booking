package com.vti.repository;

import java.util.List;

import com.vti.entity.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Short>, JpaSpecificationExecutor<Group> {

	public Group findByName(String name);

	public boolean existsByName(String name);

	public void deleteByIdIn(List<Short> ids);

}

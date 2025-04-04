package com.ha.graphql.infrastructure.driven.persistence.repository;

import com.ha.graphql.infrastructure.driven.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByName(String name);
}
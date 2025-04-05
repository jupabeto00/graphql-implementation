package com.ha.graphql.infrastructure.driven.persistence.adapter;

import com.ha.graphql.domain.model.User;
import com.ha.graphql.domain.port.UserPort;
import com.ha.graphql.infrastructure.driven.mapper.UserMapper;
import com.ha.graphql.infrastructure.driven.persistence.entity.UserEntity;
import com.ha.graphql.infrastructure.driven.persistence.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserAdapter implements UserPort {

	private UserEntityRepository userEntityRepository;
	private UserMapper userMapper;

	@Autowired
	public void setUserEntityRepository(UserEntityRepository userEntityRepository) {
		this.userEntityRepository = userEntityRepository;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getById(Long id) {
		log.debug("[START] -> Persistence - Retrieving user with id {}", id);
		UserEntity user = userEntityRepository.findById(id).orElse(null);
		log.debug("[END] -> Persistence - Retrieving user with id {}", id);
		return userMapper.toDto(user);
	}
}

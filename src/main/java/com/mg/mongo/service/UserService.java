package com.mg.mongo.service;

import com.mg.mongo.dto.UserDto;
import com.mg.mongo.mapper.UserMapper;
import com.mg.mongo.repository.UserRepository;
import com.mg.mongo.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public boolean saveUser(UserDto userDto) {
        UserEntity entity = userMapper.toEntity(userDto);
        UserEntity save = userRepository.save(entity);
        return save.getId() != null;
    }


    public List<UserDto> findUsers() {
        List<UserEntity> all = userRepository.findAll();
        return userMapper.toDtoList(all);
    }


    public Optional<UserDto> findUser(String id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(userMapper::toDto);
    }

    public void updateUser(UserDto userDto, String id) {
        UserEntity entity = userMapper.toEntity(userDto);
        entity.setId(id);
        userRepository.save(entity);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

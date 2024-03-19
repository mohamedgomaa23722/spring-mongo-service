package com.mg.mongo.mapper;

import com.mg.mongo.dto.UserDto;
import com.mg.mongo.repository.entity.UserEntity;

import java.util.List;

public interface BaseMapper<D, E> {

    D  toDto(E entity);

    E toEntity (D dto);

    List<D> toDtoList(List<E> entities);

    List<E> toEntityList(List<D> dtoList);
}

package com.mg.mongo.mapper;

import com.mg.mongo.dto.UserDto;
import com.mg.mongo.repository.entity.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends BaseMapper<UserDto, UserEntity> {

}

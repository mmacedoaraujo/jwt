package com.mmacedoaraujo.mapper;

import com.mmacedoaraujo.domain.User;
import com.mmacedoaraujo.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    void update(@MappingTarget User user, UserDTO userDTO);
    User toEntity(UserDTO userDTO);
    List<UserDTO> toDTOList(List<User> userList);

}

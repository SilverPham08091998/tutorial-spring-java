package com.example.springjava.model.userdto;

import com.example.springjava.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class ConvertUserDTO implements Convert<UserEntity, UserDTO> {
    @Override
    public UserEntity convertToEntity(final UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setJob(userDTO.getJob());
        userEntity.setAge(userDTO.getAge());
        userEntity.setAddress(userDTO.getAddress());
        userEntity.setRelation(userDTO.getRelation());
        return userEntity;
    }

    @Override
    public UserDTO convertToDTO(final UserEntity userEntity) {
        return UserDTO.builder()
                .fullName(userEntity.getFullName())
                .address(userEntity.getAddress())
                .age(userEntity.getAge())
                .job(userEntity.getJob())
                .relation(userEntity.getRelation())
                .build();
    }
}

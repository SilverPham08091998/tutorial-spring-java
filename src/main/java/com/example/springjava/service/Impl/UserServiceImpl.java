package com.example.springjava.service.Impl;

import com.example.springjava.entity.UserEntity;
import com.example.springjava.model.UserDTO;
import com.example.springjava.respository.UserRepository;
import com.example.springjava.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    ModelMapper mapper;

    @Override
    public List<UserDTO> getListUser(String fullName, String address, String job) {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> userEntityList;
        if (fullName.isEmpty() && address.isEmpty() && job.isEmpty()) {
            userEntityList = userRepository.findAll();
        } else {
            userEntityList = userRepository.findByFullNameOrAddressOrJob(fullName, address, job);
        }
        for (UserEntity userEntity : userEntityList) {
            UserDTO userDTO = mapper.map(userEntity, UserDTO.class);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public void updateFullNameByUserId(String userId, String fullName, int age) {
        int responseCode = userRepository.updateFullNameUserId(userId, fullName, age);
        if (responseCode == 0) {
            throw new RuntimeException();

        }
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findUserEntityByAuthenciationEntity_UserId(userId);
        if (userEntity == null) {
            throw new RuntimeException();
        }
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setJob(userDTO.getJob());
        userEntity.setAge(userDTO.getAge());
        userEntity.setAddress(userDTO.getAddress());
        userEntity.setModifiedDate(new Date());
        userRepository.save(userEntity);
    }


    @Override
    public void deleteUser(String userId) {

        long res = userRepository.deleteByAuthenciationEntity_UserId(userId);
        if (res == 0) {
            throw new RuntimeException();
        }
    }


}

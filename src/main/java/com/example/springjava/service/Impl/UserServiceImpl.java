package com.example.springjava.service.Impl;

import com.example.springjava.entity.UserEntity;
import com.example.springjava.model.userdto.ConvertUserDTO;
import com.example.springjava.model.userdto.UserDTO;
import com.example.springjava.respository.UserRepository;
import com.example.springjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConvertUserDTO convertUserDTO;

    @Override
    public void createUser(UserEntity userEntity) {
        userRepository.save(userEntity);

    }

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
            userDTOList.add(convertUserDTO.convertToDTO(userEntity));
        }
        return userDTOList;
    }

    @Override
    public void updateUser() {

    }
}

package com.example.springjava.security.service;

import com.example.springjava.entity.AuthenciationEntity;
import com.example.springjava.respository.AuthenciationRepository;
import com.example.springjava.respository.UserRepository;
import com.example.springjava.security.model.UserDetail;
import com.example.springjava.security.model.UserPrincipal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger(CustomUserDetailServiceImpl.class);


    @Autowired
    AuthenciationRepository authenciationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            AuthenciationEntity authenciation = authenciationRepository.findAuthenciationEntityByUsername(username);
            UserDetail userDetail = new UserDetail(
                    authenciation.getUserId(),
                    authenciation.getUsername(),
                    authenciation.getPassword(),
                    authenciation.getRoleEntity().getRoleName(),
                    authenciation.getDeviceId()
            );
            return UserPrincipal.create(userDetail);

        } catch (Exception e) {
            logger.info("Username {} is not found.", username);
            throw new UsernameNotFoundException("User not found with username : " + username);
        }
    }
}

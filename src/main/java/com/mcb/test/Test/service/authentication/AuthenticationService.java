package com.mcb.test.Test.service.authentication;

import com.mcb.test.Test.model.collection.authentication.Login;
import com.mcb.test.Test.model.config.security.UserPrincipal;
import com.mcb.test.Test.repository.authentication.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthRepository authRepository;

    public UserDetails loadLoginByUserId(String userId) {
        Optional<Login> loginEntity = authRepository.findByUserId(userId);
        if(loginEntity.isPresent()) {
            return UserPrincipal.create(loginEntity.get());
        } else {
            throw new UsernameNotFoundException("Login not found with user id : " + userId);
        }
    }

}

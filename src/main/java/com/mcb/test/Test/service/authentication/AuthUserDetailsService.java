package com.mcb.test.Test.service.authentication;

import com.mcb.test.Test.model.collection.authentication.Login;
import com.mcb.test.Test.model.config.security.UserPrincipal;
import com.mcb.test.Test.repository.authentication.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String loginOrEmail) throws UsernameNotFoundException {
        Optional<Login> loginEntity = this.authRepository.findByLoginOrEmail(loginOrEmail, loginOrEmail);
        if (loginEntity.isPresent()) {
            return UserPrincipal.create(loginEntity.get());
        } else {
            throw new UsernameNotFoundException("User with username or email '" + loginOrEmail + "' was not found");
        }
    }
}

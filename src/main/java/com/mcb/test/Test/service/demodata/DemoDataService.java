package com.mcb.test.Test.service.demodata;

import com.mcb.test.Test.model.collection.authentication.Login;
import com.mcb.test.Test.model.collection.authentication.RoleEmbeded;
import com.mcb.test.Test.model.collection.location.Region;
import com.mcb.test.Test.model.collection.user.User;
import com.mcb.test.Test.model.enumeration.authentication.RoleEnum;
import com.mcb.test.Test.repository.authentication.AuthRepository;
import com.mcb.test.Test.repository.region.RegionRepository;
import com.mcb.test.Test.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoDataService {

    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegionRepository regionRepository;

    @EventListener
    @Transactional
    public void appReady(ApplicationReadyEvent event) {
        // Verify if user login data exists
        if (!authRepository.existsByLogin("test")) {
            // create
            List<RoleEmbeded> roles = new ArrayList<RoleEmbeded>();
            roles.add(new RoleEmbeded(RoleEnum.USER));

            Login login = new Login();
            login.setLogin("test");
            login.setEmail("test@test.com");
            login.setPassword(passwordEncoder.encode("test"));
            login.setLockedAccount(false);
            login.setRoles(roles);
            login = authRepository.save(login);

            User user = new User();
            user.setFirstName("Test");
            user.setLastName("user");
            user.setLoginId(login.getId());
            userRepository.save(user);

            login.setUserId(user.getId());
            authRepository.save(login);
        }
        if (!this.regionRepository.existsByRegion("Port Louis")) {
            Region regionTemp = new Region();
            regionTemp.setRegion("Port Louis");
            this.regionRepository.save(regionTemp);

            regionTemp = new Region();
            regionTemp.setRegion("Curepipe");
            this.regionRepository.save(regionTemp);

            regionTemp = new Region();
            regionTemp.setRegion("Vacoas");
            this.regionRepository.save(regionTemp);

            regionTemp = new Region();
            regionTemp.setRegion("Port Mathurin");
            this.regionRepository.save(regionTemp);
        }
    }
}

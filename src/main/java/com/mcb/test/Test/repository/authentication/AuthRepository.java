package com.mcb.test.Test.repository.authentication;

import com.mcb.test.Test.model.collection.authentication.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends MongoRepository<Login, String> {
    public Optional<Login> findByLoginOrEmail(String login, String email);
    public Optional<Login> findByUserId(String userId);
    public Boolean existsByLogin(String login);
}

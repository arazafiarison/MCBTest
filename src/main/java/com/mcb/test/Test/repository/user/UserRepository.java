package com.mcb.test.Test.repository.user;

import com.mcb.test.Test.model.collection.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

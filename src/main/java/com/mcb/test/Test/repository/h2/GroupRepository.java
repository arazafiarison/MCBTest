package com.mcb.test.Test.repository.h2;

import com.mcb.test.Test.model.h2.entity.Groups;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Groups, Integer> {
}

package com.mcb.test.Test.repository.h2;

import com.mcb.test.Test.model.h2.entity.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Students, Integer> {
    @Query(
            value = "SELECT count(std.*) " +
            "FROM SubjectTeacher stch " +
            "JOIN Groups gp ON gp.groupId = stch.groupId " +
            "JOIN Students std ON std.groupId = gp.groupId " +
            "WHERE stch.teachedId = ?1",
            nativeQuery = true
    )
    public Optional<Integer> countStudentsByTeacherId(Integer teacherId);
}

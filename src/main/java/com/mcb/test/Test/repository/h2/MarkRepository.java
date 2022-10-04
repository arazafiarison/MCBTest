package com.mcb.test.Test.repository.h2;

import com.mcb.test.Test.model.h2.entity.Marks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarkRepository extends CrudRepository<Marks, Integer> {
    public Optional<List<Marks>> findByStudentStudentId(Integer studentId);
}

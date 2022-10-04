package com.mcb.test.Test.repository.h2;

import com.mcb.test.Test.model.h2.entity.Subjects;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends CrudRepository<Subjects, Integer> {
    @Query(
            "SELECT subj.subjectId, subj.title, subj.marks from Subjects subj " +
            "JOIN subj.marks m " +
            "JOIN Students stud ON stud = m.student " +
            "WHERE stud.studentId = ?1"
    )
    public Optional<List<Subjects>> findSubjectsAndMarksByStudentId(Integer studentId);
}

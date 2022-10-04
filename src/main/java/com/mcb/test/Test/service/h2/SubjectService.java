package com.mcb.test.Test.service.h2;

import com.mcb.test.Test.model.h2.entity.Subjects;
import com.mcb.test.Test.repository.h2.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {


    @Autowired
    private SubjectRepository subjectRepository;

    public Subjects findById(Integer subjectId) {
        Optional<Subjects> subject = this.subjectRepository.findById(subjectId);
        if (subject.isPresent()) {
            return subject.get();
        }
        return null;
    }

    public Iterable<Subjects> findAll() {
        return this.subjectRepository.findAll();
    }

    public Subjects save(Subjects subject) {
        return this.subjectRepository.save(subject);
    }

    public void deleteById(Integer subjectId) {
        this.subjectRepository.deleteById(subjectId);
    }

    public List<Subjects> getSubjectsAndMarksByStudentId(Integer studentId) {
        Optional<List<Subjects>> subjectsAndMarks = this.subjectRepository.findSubjectsAndMarksByStudentId(studentId);
        if (subjectsAndMarks.isPresent()) {
            return subjectsAndMarks.get();
        }
        return null;
    }
}

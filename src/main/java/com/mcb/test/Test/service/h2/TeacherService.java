package com.mcb.test.Test.service.h2;

import com.mcb.test.Test.model.h2.entity.SubjectTeacher;
import com.mcb.test.Test.repository.h2.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public SubjectTeacher findById(Integer teacherId) {
        Optional<SubjectTeacher> teacher = this.teacherRepository.findById(teacherId);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        return null;
    }

    public Iterable<SubjectTeacher> findAll() {
        return this.teacherRepository.findAll();
    }

    public SubjectTeacher save(SubjectTeacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    public void deleteById(Integer teacherId) {
        this.teacherRepository.deleteById(teacherId);
    }
}

package com.mcb.test.Test.service.h2;

import com.mcb.test.Test.model.h2.entity.Students;
import com.mcb.test.Test.repository.h2.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Students findById(Integer studentId) {
        Optional<Students> student = this.studentRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    public Iterable<Students> findAll() {
        return this.studentRepository.findAll();
    }

    public Students save(Students student) {
        return this.studentRepository.save(student);
    }

    public void deleteById(Integer studentId) {
        this.studentRepository.deleteById(studentId);
    }

    public Integer getNbOfStudentsByTeacher(Integer teacherId) {
        Optional<Integer> count = this.studentRepository.countStudentsByTeacherId(teacherId);
        if (count.isPresent()) {
            return count.get();
        }
        return 0;
    }
}

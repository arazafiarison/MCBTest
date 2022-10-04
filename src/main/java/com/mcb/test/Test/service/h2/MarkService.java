package com.mcb.test.Test.service.h2;

import com.mcb.test.Test.model.h2.entity.Marks;
import com.mcb.test.Test.model.h2.entity.Subjects;
import com.mcb.test.Test.repository.h2.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    public Marks findById(Integer markId) {
        Optional<Marks> mark = this.markRepository.findById(markId);
        if (mark.isPresent()) {
            return mark.get();
        }
        return null;
    }

    public Iterable<Marks> findAll() {
        return this.markRepository.findAll();
    }

    public Marks save(Marks mark) {
        return this.markRepository.save(mark);
    }

    public void deleteById(Integer markId) {
        this.markRepository.deleteById(markId);
    }

    public List<Marks> getByStudentId(Integer studentId) {
        Optional<List<Marks>> studentMarks = this.markRepository.findByStudentStudentId(studentId);
        if (studentMarks.isPresent()) {
            return studentMarks.get();
        }
        return null;
    }
}

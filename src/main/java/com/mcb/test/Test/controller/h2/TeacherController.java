package com.mcb.test.Test.controller.h2;

import com.mcb.test.Test.model.h2.entity.SubjectTeacher;
import com.mcb.test.Test.model.h2.entity.Subjects;
import com.mcb.test.Test.service.h2.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/h2/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<SubjectTeacher> findById(@PathVariable("id") Integer teacherId) {
        return new ResponseEntity<SubjectTeacher>(this.teacherService.findById(teacherId), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<SubjectTeacher>> findAll() {
        return new ResponseEntity<Iterable<SubjectTeacher>>(this.teacherService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubjectTeacher> create(@RequestBody SubjectTeacher teacher) {
        return new ResponseEntity<SubjectTeacher>(this.teacherService.save(teacher), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SubjectTeacher> update(@RequestBody SubjectTeacher teacher) {
        return new ResponseEntity<SubjectTeacher>(this.teacherService.save(teacher), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer teacherId) {
        this.teacherService.deleteById(teacherId);
        return new ResponseEntity<>("Element deleted", HttpStatus.ACCEPTED);
    }
}

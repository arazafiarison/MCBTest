package com.mcb.test.Test.controller.h2;

import com.mcb.test.Test.model.h2.entity.Marks;
import com.mcb.test.Test.model.h2.entity.Students;
import com.mcb.test.Test.service.h2.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/h2/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/countByTeacherId/{teacherId}")
    public ResponseEntity<Integer> countByTeacherId(@PathVariable("teacherId") Integer teacherId) {
        return new ResponseEntity<Integer>(this.studentService.getNbOfStudentsByTeacher(teacherId), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Students> findById(@PathVariable("id") Integer studentId) {
        return new ResponseEntity<Students>(this.studentService.findById(studentId), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Students>> findAll() {
        return new ResponseEntity<Iterable<Students>>(this.studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Students> create(@RequestBody Students student) {
        return new ResponseEntity<Students>(this.studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Students> update(@RequestBody Students student) {
        return new ResponseEntity<Students>(this.studentService.save(student), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer studentId) {
        this.studentService.deleteById(studentId);
        return new ResponseEntity<>("Element deleted", HttpStatus.ACCEPTED);
    }

}

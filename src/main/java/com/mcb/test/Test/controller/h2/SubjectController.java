package com.mcb.test.Test.controller.h2;

import com.mcb.test.Test.model.h2.entity.Subjects;
import com.mcb.test.Test.service.h2.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/h2/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/getMarksByStudentId/{studentId}")
    public ResponseEntity<List<Subjects>> getSubjectsAndMarksByStudentId(@PathVariable("studentId") Integer studentId) {
        return new ResponseEntity<List<Subjects>>(this.subjectService.getSubjectsAndMarksByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Subjects> findById(@PathVariable("id") Integer subjectId) {
        return new ResponseEntity<Subjects>(this.subjectService.findById(subjectId), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Subjects>> findAll() {
        return new ResponseEntity<Iterable<Subjects>>(this.subjectService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subjects> create(@RequestBody Subjects subject) {
        return new ResponseEntity<Subjects>(this.subjectService.save(subject), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Subjects> update(@RequestBody Subjects subject) {
        return new ResponseEntity<Subjects>(this.subjectService.save(subject), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer subjectId) {
        this.subjectService.deleteById(subjectId);
        return new ResponseEntity<>("Element deleted", HttpStatus.ACCEPTED);
    }

}

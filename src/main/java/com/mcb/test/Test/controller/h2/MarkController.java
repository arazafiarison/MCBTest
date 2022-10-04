package com.mcb.test.Test.controller.h2;

import com.mcb.test.Test.model.h2.entity.Marks;
import com.mcb.test.Test.service.h2.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/h2/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @GetMapping("/getByStudentId/{markId}")
    public ResponseEntity<List<Marks>> getByStudentId(@PathVariable("markId") Integer markId) {
        return new ResponseEntity<List<Marks>>(this.markService.getByStudentId(markId), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Marks> findById(@PathVariable("id") Integer groupId) {
        return new ResponseEntity<Marks>(this.markService.findById(groupId), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Marks>> findAll() {
        return new ResponseEntity<Iterable<Marks>>(this.markService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Marks> create(@RequestBody Marks mark) {
        return new ResponseEntity<Marks>(this.markService.save(mark), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Marks> update(@RequestBody Marks mark) {
        return new ResponseEntity<Marks>(this.markService.save(mark), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer markId) {
        this.markService.deleteById(markId);
        return new ResponseEntity<>("Element deleted", HttpStatus.ACCEPTED);
    }
}

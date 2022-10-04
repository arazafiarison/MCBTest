package com.mcb.test.Test.controller.h2;

import com.mcb.test.Test.model.h2.entity.Groups;
import com.mcb.test.Test.service.h2.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/h2/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<Groups> findById(@PathVariable("id") Integer groupId) {
        return new ResponseEntity<Groups>(this.groupService.findById(groupId), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Groups>> findAll() {
        return new ResponseEntity<Iterable<Groups>>(this.groupService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Groups> create(@RequestBody Groups group) {
        return new ResponseEntity<Groups>(this.groupService.save(group), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Groups> update(@RequestBody Groups group) {
        return new ResponseEntity<Groups>(this.groupService.save(group), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer groupId) {
        this.groupService.deleteById(groupId);
        return new ResponseEntity<>("Element deleted", HttpStatus.ACCEPTED);
    }

}

package com.mcb.test.Test.service.h2;

import com.mcb.test.Test.model.h2.entity.Groups;
import com.mcb.test.Test.repository.h2.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Groups findById(Integer groupId) {
        Optional<Groups> group = this.groupRepository.findById(groupId);
        if (group.isPresent()) {
            return group.get();
        }
        return null;
    }

    public Iterable<Groups> findAll() {
        return this.groupRepository.findAll();
    }

    public Groups save(Groups group) {
        return this.groupRepository.save(group);
    }

    public void deleteById(Integer groupId) {
        this.groupRepository.deleteById(groupId);
    }
}

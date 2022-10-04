package com.mcb.test.Test.model.h2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;
    private String title;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Marks> marks;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<SubjectTeacher> teachers;
}

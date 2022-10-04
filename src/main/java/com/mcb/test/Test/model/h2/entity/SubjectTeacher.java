package com.mcb.test.Test.model.h2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SubjectTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teachedId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subjectId", nullable = false)
    private Subjects subject;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groupId", nullable = false)
    private Groups group;
}

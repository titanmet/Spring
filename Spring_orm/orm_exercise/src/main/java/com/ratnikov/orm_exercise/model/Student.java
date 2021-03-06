package com.ratnikov.orm_exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
@NamedEntityGraph(name = "student-avatar-entity-graphs",
        attributeNodes = {@NamedAttributeNode("avatar")})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "student_name", nullable = false, unique = true)
    private String name;

    @OneToOne(targetEntity = Avatar.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", foreignKey = @ForeignKey(name = "FK_avatar"))
    private Avatar avatar;

    @OneToMany(targetEntity = EMail.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "FK_student"))
    private List<EMail> emails;

    //    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 5)
    @ManyToMany(targetEntity = Course.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}
package com.microservices.microservice1course.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "course")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Column(name = "sub_title", length = 100, nullable = false)
    @NotBlank(message = "subtitle cannot be empty")
    private String subtitle;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Price cannot be null")
    private Double price;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return id != null && Objects.equals(id, course.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}

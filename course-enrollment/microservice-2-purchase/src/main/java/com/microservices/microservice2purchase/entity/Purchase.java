package com.microservices.microservice2purchase.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "purchase")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Purchase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId", nullable = false)
    @NotNull(message = "UserId cannot be null")
    private Long userId;

    @Column(name = "courseId", nullable = false)
    @NotNull(message = "courseId cannot be null")
    private Long courseId;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Course title cannot be null")
    private String title;

    @Column(name = "price", nullable = false)
    @Positive(message = "Course price should be positive")
    private Double price;

    @Column(name = "purchaseTime", nullable = false)
    private LocalDateTime purchaseTime;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Purchase purchase = (Purchase) o;
        return id != null && Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}

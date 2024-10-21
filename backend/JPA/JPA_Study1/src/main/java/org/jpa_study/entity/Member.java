package org.jpa_study.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table(name="MEMBER")
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint(
        name="NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"}
)})
public class Member {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private String temp;
}

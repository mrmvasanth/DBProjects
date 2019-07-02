package com.packs.flyy.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.packs.flyy.models.enums.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    @Column(length = 3)
    private RoleName name;

    public Roles() {
    }
}

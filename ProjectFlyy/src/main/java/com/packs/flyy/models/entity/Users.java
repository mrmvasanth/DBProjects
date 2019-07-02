package com.packs.flyy.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.packs.flyy.models.audit.DateAudit;
import sun.plugin.util.UserProfile;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class Users extends DateAudit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID user_id;


    private String jwt_token;

    @Column(name = "token_expiry", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date token_expiry;


    @OneToOne(mappedBy = "user_id",cascade = CascadeType.ALL)
    private UsersProfiles usersProfiles;





}

package com.packs.flyy.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.packs.flyy.models.audit.DateAudit;
import sun.plugin.util.UserProfile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class Users extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String jwt_token;

    @Column(name = "token_expiry", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date token_expiry;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName ="user_id",updatable = true,insertable = true)
    private List<UsersProfiles> usersProfiles;

    public List<UsersProfiles> getUsersProfiles() {
        return usersProfiles;
    }

    public void setUsersProfiles(List<UsersProfiles> usersProfiles) {
        this.usersProfiles = usersProfiles;
    }

    public Users() {
    }

    public Users(String jwt_token, Date token_expiry, UsersProfiles usersProfiles) {
        this.jwt_token = jwt_token;
        this.token_expiry = token_expiry;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getJwt_token() {
        return jwt_token;
    }

    public void setJwt_token(String jwt_token) {
        this.jwt_token = jwt_token;
    }

    public Date getToken_expiry() {
        return token_expiry;
    }

    public void setToken_expiry(Date token_expiry) {
        this.token_expiry = token_expiry;
    }



}

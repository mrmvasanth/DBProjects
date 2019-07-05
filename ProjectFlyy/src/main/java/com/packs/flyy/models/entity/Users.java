package com.packs.flyy.models.entity;

import com.packs.flyy.models.audit.DateAudit;
import com.packs.flyy.models.entity.Admin.AdminProfiles;
import com.packs.flyy.models.entity.Agent.AgentProfiles;
import com.packs.flyy.models.entity.Client.UsersProfiles;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Users extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String jwt_token;

    @Column(name = "token_expiry", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date token_expiry;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName ="userid",updatable = true,insertable = true)
    private List<UsersProfiles> usersProfiles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName ="userid",updatable = true,insertable = true)
    private List<AdminProfiles>  adminProfiles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName ="userid",updatable = true,insertable = true)
    private List<AgentProfiles> agentProfiles;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Roles roles;

    public Users() {
    }

    public Users(Long userid, String jwt_token, Date token_expiry, List<UsersProfiles> usersProfiles,
                 List<AdminProfiles> adminProfiles, @NotNull Roles roles) {
        this.userid = userid;
        this.jwt_token = jwt_token;
        this.token_expiry = token_expiry;
        this.usersProfiles = usersProfiles;
        this.adminProfiles = adminProfiles;
        this.roles = roles;
    }

    public Users(@NotNull Roles roles) {
        this.roles = roles;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    public List<UsersProfiles> getUsersProfiles() {
        return usersProfiles;
    }

    public void setUsersProfiles(List<UsersProfiles> usersProfiles) {
        this.usersProfiles = usersProfiles;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}

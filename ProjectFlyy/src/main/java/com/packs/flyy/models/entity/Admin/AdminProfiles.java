package com.packs.flyy.models.entity.Admin;

import com.packs.flyy.models.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "admin_profiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class AdminProfiles extends DateAudit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userid;

    @Size(max = 40)
    private String name;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String username;

    @NotBlank
    @NotNull
    @Size(min = 8, max = 100)
    private String password;

    public AdminProfiles() {
    }

    public AdminProfiles(Long userid,
                         @NotBlank @NotNull @Size(max = 20) String username,
                         @NotBlank @NotNull @Size(min = 8, max = 100) String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

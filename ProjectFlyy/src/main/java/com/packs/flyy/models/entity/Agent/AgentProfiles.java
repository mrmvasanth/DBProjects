package com.packs.flyy.models.entity.Agent;

import com.packs.flyy.models.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "agent_profiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class AgentProfiles extends DateAudit implements Serializable {

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

    public AgentProfiles() {
    }

    public AgentProfiles(Long userid,
                         @NotBlank @NotNull @Size(max = 20) String username,
                         @NotBlank @NotNull @Size(min = 8, max = 100) String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public AgentProfiles(Long id, Long userid, @Size(max = 40) String name,
                         @NotBlank @NotNull @Size(max = 20) String username,
                         @NotBlank @NotNull @Size(min = 8, max = 100) String password) {
        this.id = id;
        this.userid = userid;
        this.name = name;
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

package com.packs.flyy.models.entity.Client;

import com.packs.flyy.models.audit.DateAudit;
import org.hibernate.annotations.NaturalId;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "users_profiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "phone_number"
        })
})
public class UsersProfiles extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int userid;

    @Size(max = 40)
    private String name;

    @NaturalId
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @NotNull
    @Size(min=10,max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone_number;

    @Size(max = 40)
    private String ename;

    @Size(min=10,max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String econtact;

    private String photo_url;

    @Size(max = 3)
    private String active_status;

    @Size(max = 10)
    private String referral_code;


    public UsersProfiles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEcontact() {
        return econtact;
    }

    public void setEcontact(String econtact) {
        this.econtact = econtact;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status;
    }

    public String getReferral_code() {
        return referral_code;
    }

    public void setReferral_code(String referral_code) {
        this.referral_code = referral_code;
    }
}

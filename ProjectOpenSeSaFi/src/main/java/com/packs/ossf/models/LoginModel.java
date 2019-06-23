package com.packs.ossf.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Entity
public class LoginModel {

    @Id
    private @Getter @Setter String username;
    private @Getter @Setter String password;
}

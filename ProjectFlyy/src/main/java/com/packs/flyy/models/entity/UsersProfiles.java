package com.packs.flyy.models.entity;

import com.packs.flyy.models.audit.DateAudit;
import org.hibernate.annotations.NaturalId;
import sun.plugin.util.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
@Table(name = "users_profiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "phone_number"
        })
})
public class UsersProfiles extends DateAudit {

    @Id
    @OneToOne
    @JoinColumn
    @MapsId
    private UUID user_id;

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


}

package com.codestates.soloproject.BusinessCommunity.member.entity;

import com.codestates.soloproject.BusinessCommunity.company.CompanyType;
import com.codestates.soloproject.BusinessCommunity.location.CompanyLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    private String name;

    private String sex;

    @JsonIgnore
    private String password;

    private String companyName;

    @ManyToOne
    @JoinColumn(name = "COMPANY_TYPE_ID")
    private CompanyType companyType;

    @ManyToOne
    @JoinColumn(name = "COMPANY_LOCATION_ID")
    private CompanyLocation companyLocation;

}

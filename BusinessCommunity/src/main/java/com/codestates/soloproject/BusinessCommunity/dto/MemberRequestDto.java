//package com.codestates.soloproject.BusinessCommunity.dto;
//
//import com.codestates.soloproject.BusinessCommunity.company.CompanyType;
//import com.codestates.soloproject.BusinessCommunity.location.CompanyLocation;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//
//
//public class MemberRequestDto {
//
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
//    public static class createMember{
//
//        private String name;
//
//        @JsonIgnore
//        private String password;
//
//        private String sex;
//
//        @Column(unique = true)
//        private String companyName;
//
//        private CompanyType.types companyType;
//
//        private CompanyLocation.Locations companyLocation;
//
//
//    }
//}

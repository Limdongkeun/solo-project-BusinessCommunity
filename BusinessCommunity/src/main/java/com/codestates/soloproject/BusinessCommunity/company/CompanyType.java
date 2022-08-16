package com.codestates.soloproject.BusinessCommunity.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyType {

    @Id
    private long companyTypeId;

    @Enumerated(value = EnumType.STRING)
    private types type;

    public enum types {
        IT,
        MEDICAL,
        ECOMMERCE,
        ELECTRICITY,
        SI,
    }

//    public enum types {
//
//        IT(1),
//        MEDICAL(2),
//        ECOMMERCE(3),
//        ELECTRICITY(4),
//        EDUCATION(5);
//
//        @Getter
//        private final int num;
//
//        types(int num){
//            this.num=num;
//        }
//
//        public int getType(){
//            return num;
//        }
//
//        public types valueOf(int num){
//            for (types companyType : CompanyType.types.values()){
//                if(companyType.getType() == num){
//                    return companyType;
//                }
//            }
//            return null;
//        }
//    }


}

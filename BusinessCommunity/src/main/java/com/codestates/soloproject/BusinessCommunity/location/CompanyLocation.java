package com.codestates.soloproject.BusinessCommunity.location;

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
public class CompanyLocation {
    @Id
    private long companyLocationId;

    @Enumerated(value = EnumType.ORDINAL)
    private Locations location;

        public enum Locations {
        서울,
        용인,
        인천,
        부산,
        수원

    }

//     public enum Locations {
//
//        강남구(1),
//        송파구(2),
//        영등포구(3),
//        성북구(4),
//        강동구(5);
//
//        @Getter
//        private final int num;
//
//        Locations(int num){
//            this.num=num;
//        }
//
//        public int getLocation(){
//            return num;
//        }
//
//        public Locations valueOf(int num){
//            for (Locations companyLocation : CompanyLocation.Locations.values()){
//                if(companyLocation.getLocation() == num){
//                    return companyLocation;
//                }
//            }
//            return null;
//        }
//    }


}

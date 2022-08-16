package com.codestates.soloproject.BusinessCommunity.stubData;

import com.codestates.soloproject.BusinessCommunity.company.CompanyType;
import com.codestates.soloproject.BusinessCommunity.location.CompanyLocation;
import com.codestates.soloproject.BusinessCommunity.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberStub {
    private static List<CompanyLocation> companyLocations = new ArrayList<>(List.of(
            new CompanyLocation(1L, CompanyLocation.Locations.서울),
            new CompanyLocation(2L, CompanyLocation.Locations.용인),
            new CompanyLocation(3L, CompanyLocation.Locations.인천),
            new CompanyLocation(4L, CompanyLocation.Locations.부산),
            new CompanyLocation(5L, CompanyLocation.Locations.수원)
    ));

    private static List<CompanyType> companyTypes = new ArrayList<>(List.of(
            new CompanyType(1L, CompanyType.types.IT),
            new CompanyType(2L, CompanyType.types.MEDICAL),
            new CompanyType(3L, CompanyType.types.ECOMMERCE),
            new CompanyType(4L, CompanyType.types.ELECTRICITY),
            new CompanyType(5L, CompanyType.types.SI)
    ));

    public static Member getMember() {
        return new Member(1L,
                "김코딩",
                "M",
                "s4goodbye!",
                "LG",
                companyTypes.get(1),
                companyLocations.get(2));
    }

    public static List<Member> getMembers() {
        return new ArrayList<>(List.of(
                getMember(),
                new Member(2L, "HGD", "M", "s4goodbye!", "codestates", companyTypes.get(2), companyLocations.get(3)),
                new Member(3L, "LBW", "W", "s4goodbye!", "samsung", companyTypes.get(1), companyLocations.get(4))
        ));
    }

    public static List<Member> getMembersByLocationAndSector() {
        return new ArrayList<>(List.of(
                getMember()
        ));
    }
}

package com.codestates.soloproject.BusinessCommunity.member.repository;

import com.codestates.soloproject.BusinessCommunity.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT * FROM MEMBER m " +
            "LEFT JOIN COMPANY_TYPE c ON c.COMPANY_TYPE_ID = m.COMPANY_TYPE_ID " +
            "LEFT JOIN COMPANY_LOCATION l on l.COMPANY_LOCATION_ID = m.COMPANY_LOCATION_ID " +
            "WHERE l.LOCATION = :location AND c.TYPE = :type", nativeQuery = true)
    List<Member> findAllByLocationAndSector(@Param("location") String location, @Param("type") String type);
}

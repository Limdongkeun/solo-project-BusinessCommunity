package com.codestates.soloproject.BusinessCommunity.member.controller;

import com.codestates.soloproject.BusinessCommunity.member.entity.Member;
import com.codestates.soloproject.BusinessCommunity.member.service.MemberService;
import com.codestates.soloproject.BusinessCommunity.stubData.MemberStub;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.codestates.soloproject.BusinessCommunity.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.soloproject.BusinessCommunity.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private Gson gson;

    @Test
    @DisplayName("?????? ?????? ??????")
    void getMembers() throws Exception {
        // given
        List<Member> members = MemberStub.getMembers();
        given(memberService.findMembers()).willReturn(members);

        // when
        ResultActions actions = mockMvc.perform(
                get("/v1/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // then
        actions
                .andExpect(status().isOk())
                .andDo(document(
                        "get-members",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        responseFields(
                                List.of(
                                        fieldWithPath("[].memberId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("?????? ??????"),
                                        fieldWithPath("[].sex").type(JsonFieldType.STRING).description("?????? ??????"),
                                        fieldWithPath("[].companyName").type(JsonFieldType.STRING).description("?????? ?????????"),
                                        fieldWithPath("[].companyType").type(JsonFieldType.OBJECT).description("?????? ?????? ?????? ?????????"),
                                        fieldWithPath("[].companyType.companyTypeId").type(JsonFieldType.NUMBER).description("?????? ?????? ?????? ?????????"),
                                        fieldWithPath("[].companyType.type").type(JsonFieldType.STRING).description("?????? ?????? ?????? ??????"),
                                        fieldWithPath("[].companyLocation").type(JsonFieldType.OBJECT).description("?????? ?????? ?????? ?????????"),
                                        fieldWithPath("[].companyLocation.companyLocationId").type(JsonFieldType.NUMBER).description("?????? ?????? ?????? ?????????"),
                                        fieldWithPath("[].companyLocation.location").type(JsonFieldType.STRING).description("?????? ?????? ??????")
                                )
                        )
                ));
    }

    @Test
    @DisplayName("??????, ????????? ?????? ?????? ??????")
    void getMember() throws Exception {
        // given
        String location = "??????";
        String type = "IT";
        List<Member> members = MemberStub.getMembersByLocationAndSector();
        given(memberService.findMembersByQuery(Mockito.anyString(), Mockito.anyString())).willReturn(members);

        // when
        ResultActions actions = mockMvc.perform(
                get("/v1/members/company?location={location}&type={type}", location, type)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        actions
                .andExpect(status().isOk())
                .andDo(document(
                        "get-members-by-location-type",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                parameterWithName("location").description("?????? ??????"),
                                parameterWithName("type").description("??????")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("[].memberId").type(JsonFieldType.NUMBER).description("?????? ?????????"),
                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("?????? ??????"),
                                        fieldWithPath("[].sex").type(JsonFieldType.STRING).description("?????? ??????"),
                                        fieldWithPath("[].companyName").type(JsonFieldType.STRING).description("?????? ?????????"),
                                        fieldWithPath("[].companyType").type(JsonFieldType.OBJECT).description("?????? ?????? ?????? ?????????"),
                                        fieldWithPath("[].companyType.companyTypeId").type(JsonFieldType.NUMBER).description("?????? ?????? ?????? ?????????"),
                                        fieldWithPath("[].companyType.type").type(JsonFieldType.STRING).description("?????? ?????? ?????? ??????"),
                                        fieldWithPath("[].companyLocation").type(JsonFieldType.OBJECT).description("?????? ?????? ?????? ?????????"),
                                        fieldWithPath("[].companyLocation.companyLocationId").type(JsonFieldType.NUMBER).description("?????? ?????? ?????? ?????????"),
                                        fieldWithPath("[].companyLocation.location").type(JsonFieldType.STRING).description("?????? ?????? ??????")
                                )
                        )
                ));
    }
}
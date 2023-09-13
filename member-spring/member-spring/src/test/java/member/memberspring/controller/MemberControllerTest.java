package member.memberspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import member.memberspring.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MemberService memberService;

    @Autowired
    ObjectMapper objectMapper; // 자바object를 json으로 바꿔주는 젝슨오브젝트

    @Test
    @DisplayName("회원가입 성공")
    void join(){
        String userName = "yongwoo";
        String passWord = "1234";


        mockMvc.perform(post())

    }


}
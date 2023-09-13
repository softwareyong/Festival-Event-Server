package member.memberspring.controller;

import lombok.RequiredArgsConstructor;
import member.memberspring.dto.MemberDTO;
import member.memberspring.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor // lombok에서 제공하는 어노테이션
@RequestMapping("/admin_member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);

        if (loginResult != null) {
            // 로그인 성공
            session.setAttribute("loginName", loginResult.getUserid());
            // 200 ok 응답 반환
            return ResponseEntity.ok().body("{\"response\": 200}");
        } else{
            // 로그인 실패
            // 402
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("{\"response\": 402}");
        }
    }



    @GetMapping("/login")
    public String loginForm(){
        return "test";
    }

}

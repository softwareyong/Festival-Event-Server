package member.memberspring.controller;

import lombok.RequiredArgsConstructor;
import member.memberspring.dto.MemberDTO;
import member.memberspring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor // lombok에서 제공하는 어노테이션
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    // 객체 주입방식은 3가지 정도가 있는데
    // 여기서는 생성자 주입방식 사용

    // 회원가입 url 폐쇄 예정
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "index";
    }
    // ---------------------------------------------

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
       MemberDTO loginResult = memberService.login(memberDTO);
       if (loginResult != null){
           //login 성공
           session.setAttribute("loginName", loginResult.getUserid());
           return "event";
       } else {
           // login 실패
           return "login";
       }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // 세션을 무효화한다.
        return "index";
    }

}

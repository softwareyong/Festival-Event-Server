package member.memberspring.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import member.memberspring.dto.MemberDTO;
import member.memberspring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor // lombok에서 제공하는 어노테이션
public class EventController {

    private final MemberService memberService;

    @GetMapping("/admin/event")
    public String eventPage(@ModelAttribute MemberDTO memberDTO, HttpSession session)
    {
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

//    @GetMapping("/event")
//    public String eventPage()
//    {
//            return "event";
//    }

}

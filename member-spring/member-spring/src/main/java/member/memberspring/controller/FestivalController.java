package member.memberspring.controller;

import lombok.RequiredArgsConstructor;
import member.memberspring.dto.event.BoxDTO;
import member.memberspring.dto.event.DressDTO;
import member.memberspring.dto.event.TicketDTO;
import member.memberspring.entity.EventEntity;
import member.memberspring.service.EventClientService;
import member.memberspring.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor // lombok에서 제공하는 어노테이션
@RequestMapping("/event")
public class FestivalController {

    private final EventService eventService;

    // 모든 정보 요청
    // 관리자 페이지 api
    @GetMapping("/event_all")
    public ResponseEntity<EventEntity> getEventById(){
        EventEntity eventEntity = eventService.getAllEventInfo();
        if (eventEntity != null) {
            return ResponseEntity.ok(eventEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 1. 티켓 API
    @GetMapping("/ticket")
    public ResponseEntity<TicketDTO> getTicketInfo(){
        TicketDTO ticketDTO = eventService.getAllTicketInfo();
        return ResponseEntity.ok(ticketDTO);
    }

    // 2. 보물상자 API
    @GetMapping("/box")
    public ResponseEntity<BoxDTO> getBoxInfo(){
        BoxDTO boxDTO = eventService.getAllBoxInfo();
        return ResponseEntity.ok(boxDTO);
    }

    // 3. 드레스코드 API
    @GetMapping("/dress")
    public ResponseEntity<DressDTO> getDressInfo(){
        DressDTO dressDTO = eventService.getAllDressInfo();
        return ResponseEntity.ok(dressDTO);
    }
}

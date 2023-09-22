package com.admin.festival.controller;


import com.admin.festival.dto.EventDTO;
import com.admin.festival.dto.event.*;
import com.admin.festival.service.*;
import com.admin.festival.entity.EventEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor // lombok에서 제공하는 어노테이션
@RequestMapping("/event")
public class EventClientApiController {

    private final EventService eventService;

    @GetMapping("/event_all")
//    @Cacheable(cacheNames = "eventAll")
    public ResponseEntity<EventEntity> getEventById() {
        System.out.println();
        EventEntity eventEntity = eventService.getAllEventInfo();
        if (eventEntity != null) {
            return ResponseEntity.ok(eventEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 1. 티켓 API
    @GetMapping("/ticket")
    @Cacheable(cacheNames = "ticket")
    public ResponseEntity<TicketDTO> getTicketInfo(){
        TicketDTO ticketDTO = eventService.getAllTicketInfo();
        return ResponseEntity.ok(ticketDTO);
    }

    // 2. 보물상자 API
    @GetMapping("/box")
    @Cacheable(cacheNames = "box")
    public ResponseEntity<BoxDTO> getBoxInfo(){
        BoxDTO boxDTO = eventService.getAllBoxInfo();
        return ResponseEntity.ok(boxDTO);
    }

    // 3. 드레스코드 API
    @GetMapping("/dress")
    @Cacheable(cacheNames = "dress")
    public ResponseEntity<DressDTO> getDressInfo(){
        DressDTO dressDTO = eventService.getAllDressInfo();
        return ResponseEntity.ok(dressDTO);
    }

}

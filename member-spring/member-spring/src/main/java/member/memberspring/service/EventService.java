package member.memberspring.service;

import lombok.RequiredArgsConstructor;
import member.memberspring.dto.EventDTO;
import member.memberspring.dto.event.BoxDTO;
import member.memberspring.dto.event.DressDTO;
import member.memberspring.dto.event.TicketDTO;
import member.memberspring.entity.EventEntity;
import member.memberspring.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public void ticket_update(int count){
        // EventRepository를 사용하여 이벤트 엔티티를 가져옵니다.
        Optional<EventEntity> eventOptional = eventRepository.findById(1L); // 첫번째 줄 불러옴
        if (eventOptional.isPresent()) {
            EventEntity eventEntity = eventOptional.get();

            // 티켓 값을 count로 업데이트합니다.
            eventEntity.setTicket(count);

            // 업데이트된 엔티티를 저장합니다.
            eventRepository.save(eventEntity);
    }else {
            // 해당 eventId에 해당하는 이벤트가 없는 경우 처리
            throw new EntityNotFoundException("Ticket not found for id: " + 1);
        }
    }

    public void box_toggle(int value) {
        Optional<EventEntity> eventOptional = eventRepository.findById(1L); // 첫번째 줄 불러옴
        if (eventOptional.isPresent()) {  // 값이 있다면
            EventEntity eventEntity = eventOptional.get();

            // 속성 이름을 결정합니다.
            String attributeName = "box" + value;

            // 해당 속성 값을 토글합니다.
            int currentValue = eventEntity.getAttributeValue(attributeName);
            int updatedValue = (currentValue == 0) ? 1 : 0;
            eventEntity.setAttributeValue(attributeName, updatedValue);

            // 업데이트된 엔티티를 저장합니다.
            eventRepository.save(eventEntity);
        }else {
            // 해당 eventId에 해당하는 이벤트가 없는 경우 처리
            throw new EntityNotFoundException("box not found for id: " + 1);
        }
    }

    public void dress_toggle(int value) {
        Optional<EventEntity> eventOptional = eventRepository.findById(1L); // 첫번째 줄 불러옴
        if (eventOptional.isPresent()) {  // 값이 있다면
            EventEntity eventEntity = eventOptional.get();

            // 속성 이름을 결정합니다.
            String attributeName = "dress" + value;

            // 해당 속성 값을 토글합니다.
            int currentValue = eventEntity.getAttributeValue(attributeName);
            int updatedValue = (currentValue == 0) ? 1 : 0;
            eventEntity.setAttributeValue(attributeName, updatedValue);

            // 업데이트된 엔티티를 저장합니다.
            eventRepository.save(eventEntity);
        }else {
            // 해당 eventId에 해당하는 이벤트가 없는 경우 처리
            throw new EntityNotFoundException("Dress not found for id: " + 1);
        }
    }

    // 이벤트 정보를 가져오는 메서드를 구현합니다.
    public EventEntity getAllEventInfo(){
        //첫번째 행 반환
        Optional<EventEntity> eventEntityOptional = eventRepository.findById(1L);
        return eventEntityOptional.orElse(null); // 행이 없을 경우 null 반환
    }

    // 엔티티를 가져와서 ticket 필드의 값을 반환하는 메서드
    public TicketDTO getAllTicketInfo() {
        Optional<EventEntity> eventOptional = eventRepository.findById(1L); // 첫 번째 행을 가져오도록 예시로 설정
        if (eventOptional.isPresent()) {
            EventEntity eventEntity = eventOptional.get();
            return new TicketDTO(eventEntity.getTicket()); // ticket 필드의 값을 반환
        } else {
            throw new EntityNotFoundException("TicketEntity not found");
        }
    }

    // 엔티티를 가져와서 box 필드들의 값을 반환하는 메서드
    public BoxDTO getAllBoxInfo() {
        Optional<EventEntity> eventOptional = eventRepository.findById(1L); // 첫 번째 행을 가져오도록 예시로 설정
        if (eventOptional.isPresent()) {
            EventEntity eventEntity = eventOptional.get();
            return new BoxDTO(eventEntity.getBox1(), eventEntity.getBox2(), eventEntity.getBox3(), eventEntity.getBox4());
        } else {
            throw new EntityNotFoundException("BoxEntity not found");
        }
    }

    public DressDTO getAllDressInfo() {
        Optional<EventEntity> eventOptional = eventRepository.findById(1L); // 첫 번째 행을 가져오도록 예시로 설정
        if (eventOptional.isPresent()) {
            EventEntity eventEntity = eventOptional.get();
            return new DressDTO(eventEntity.getDress1(), eventEntity.getDress2());
        } else {
            throw new EntityNotFoundException("DressEntity not found");
        }
    }

}


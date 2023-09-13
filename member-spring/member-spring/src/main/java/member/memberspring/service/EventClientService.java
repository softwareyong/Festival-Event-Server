package member.memberspring.service;

import lombok.RequiredArgsConstructor;
import member.memberspring.dto.event.BoxDTO;
import member.memberspring.dto.event.DressDTO;
import member.memberspring.entity.EventEntity;
import member.memberspring.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventClientService {

    private final EventRepository eventRepository;

    // 1.만약에 5분마다 업데이트한다면
    public EventEntity getAllEventInfo(){
        //첫번째 행 반환
        Optional<EventEntity> eventEntityOptional = eventRepository.findById(1L);
        return eventEntityOptional.orElse(null); // 행이 없을 경우 null 반환
    }

    // 2. 계속 API를 준다면

    // 2-1 티켓만
    public int getTicketInfo() {
        Optional<EventEntity> eventEntityOptional = eventRepository.findById(1L);
        if (eventEntityOptional.isPresent()) {
            EventEntity eventEntity = eventEntityOptional.get();
            return eventEntity.getTicket();
        }
        return 0; // 이벤트 정보가 없는 경우 기본값을 반환하거나 예외 처리를 추가할 수 있습니다.
    }


    // 2-2 박스만
    public BoxDTO getBoxInfo() {
        Optional<EventEntity> eventEntityOptional = eventRepository.findById(1L);
        if (eventEntityOptional.isPresent()) {
            EventEntity eventEntity = eventEntityOptional.get();
            BoxDTO boxDTO = new BoxDTO();
            boxDTO.setBox1(eventEntity.getBox1());
            boxDTO.setBox2(eventEntity.getBox2());
            boxDTO.setBox3(eventEntity.getBox3());
            boxDTO.setBox4(eventEntity.getBox4());
            return boxDTO;
        }
        return new BoxDTO(); // 이벤트 정보가 없는 경우 빈 BoxDTO 객체를 반환하거나 예외 처리를 추가할 수 있습니다.
    }

    // 2-3 드레스만
    public DressDTO getDressInfo() {
        Optional<EventEntity> eventEntityOptional = eventRepository.findById(1L);
        if (eventEntityOptional.isPresent()) {
            EventEntity eventEntity = eventEntityOptional.get();
            DressDTO dressDTO = new DressDTO();
            dressDTO.setDress1(eventEntity.getDress1());
            dressDTO.setDress2(eventEntity.getDress2());
            return dressDTO;
        }
        return new DressDTO(); // 이벤트 정보가 없는 경우 빈 DressDTO 객체를 반환하거나 예외 처리를 추가할 수 있습니다.
    }

}

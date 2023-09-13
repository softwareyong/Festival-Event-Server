package member.memberspring.dto;


import lombok.*;
import member.memberspring.dto.event.BoxDTO;
import member.memberspring.dto.event.DressDTO;
import member.memberspring.dto.event.TicketDTO;
import member.memberspring.entity.EventEntity;

@Getter // lombok: Getter 자동으로
@Setter // lombok: Setter 자동으로
@NoArgsConstructor // lombok: 기본생성자를 자동으로 만들어준다.
@AllArgsConstructor
@ToString // lombok: ToString 메서드를 자동으로 만들어준다.
public class EventDTO {

    private Long id;
    private TicketDTO ticketDTO;
    private BoxDTO boxDTO;
    private DressDTO dressDTO;

    public static EventDTO toEventDTO(EventEntity eventEntity){

        EventDTO eventDTO = new EventDTO();
        // eventDTO 객체를 적절하게 초기화하고, TicketDTO, BoxDTO, DressDTO를 설정

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicket(eventEntity.getTicket());
        eventDTO.setTicketDTO(ticketDTO);

//        eventDTO.setTicket(eventEntity.getTicket());
//        eventDTO.setBox1(eventEntity.getBox1());
//        eventDTO.setBox2(eventEntity.getBox2());
//        eventDTO.setBox3(eventEntity.getBox3());
//        eventDTO.setBox4(eventEntity.getBox4());

        return eventDTO;
    }

}

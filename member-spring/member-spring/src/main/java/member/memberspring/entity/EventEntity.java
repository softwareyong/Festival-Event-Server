package member.memberspring.entity;


import lombok.Getter;
import lombok.Setter;
import member.memberspring.dto.EventDTO;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "event_table")
public class EventEntity {
    @Id // pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    // 1. 비행기티켓
    @Column
    private int ticket;

    // 2. 보물차기
    @Column
    private int box1;
    @Column
    private int box2;
    @Column
    private int box3;
    @Column
    private int box4;

    // 3. 드레스코드
    @Column
    private int dress1;
    @Column
    private int dress2;


    public static EventEntity toEventEntity(EventDTO eventDTO){

        // 출력
        System.out.println(eventDTO.getTicketDTO().getTicket());
        System.out.println(eventDTO.getBoxDTO().getBox1());
        System.out.println(eventDTO.getBoxDTO().getBox2());
        System.out.println(eventDTO.getBoxDTO().getBox3());
        System.out.println(eventDTO.getBoxDTO().getBox4());

        EventEntity eventEntity = new EventEntity();

        // 1. Ticket
        eventEntity.setTicket(eventDTO.getTicketDTO().getTicket());

        // 2. Box
        eventEntity.setBox1(eventDTO.getBoxDTO().getBox1());
        eventEntity.setBox2(eventDTO.getBoxDTO().getBox2());
        eventEntity.setBox3(eventDTO.getBoxDTO().getBox3());
        eventEntity.setBox4(eventDTO.getBoxDTO().getBox4());

        // 3. Dress
        eventEntity.setDress1(eventDTO.getDressDTO().getDress1());
        eventEntity.setDress2(eventDTO.getDressDTO().getDress2());


        return eventEntity;
    }

    // getAttributeValue: attributeName에 해당하는 속성 값을 가져옵니다.
    public int getAttributeValue(String attributeName){
        switch (attributeName) {
            case "box1":
                return this.getBox1();
            case "box2":
                return this.getBox2();
            case "box3":
                return this.getBox3();
            case "box4":
                return this.getBox4();
            case "dress1":
                return this.getDress1();
            case "dress2":
                return this.getDress2();

            default:
                throw new IllegalArgumentException("Invalid attributeName: " + attributeName);
        }
    }

    public void setAttributeValue(String attributeName, int value) {
        switch (attributeName) {
            case "box1":
                this.setBox1(value);
                break;
            case "box2":
                this.setBox2(value);
                break;
            case "box3":
                this.setBox3(value);
                break;
            case "box4":
                this.setBox4(value);
                break;
            case "dress1":
                this.setDress1(value);
                break;
            case "dress2":
                this.setDress2(value);
                break;

            default:
                throw new IllegalArgumentException("Invalid attributeName: " + attributeName);
        }
    }
}

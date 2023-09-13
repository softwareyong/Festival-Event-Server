package member.memberspring.dto.event;

import lombok.*;

@Getter // lombok: Getter 자동으로
@Setter // lombok: Setter 자동으로
@NoArgsConstructor // lombok: 기본생성자를 자동으로 만들어준다.
@AllArgsConstructor
@ToString // lombok: ToString 메서드를 자동으로 만들어준다.
public class DressDTO {

    private int dress1;
    private int dress2;

}

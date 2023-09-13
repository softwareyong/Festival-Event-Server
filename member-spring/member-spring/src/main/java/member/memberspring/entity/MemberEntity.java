package member.memberspring.entity;

import lombok.Getter;
import lombok.Setter;
import member.memberspring.dto.MemberDTO;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id // pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

//    @Column(unique = true)
    private String userid;

    @Column
    private String userpw;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        System.out.println("안녕");
        System.out.println(memberDTO.getUserid());
        System.out.println(memberDTO.getUserpw());

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setUserid(memberDTO.getUserid());
        memberEntity.setUserpw(memberDTO.getUserpw());

        return memberEntity;
    }

}

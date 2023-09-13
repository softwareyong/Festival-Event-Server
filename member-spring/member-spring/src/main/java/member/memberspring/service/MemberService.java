package member.memberspring.service;

import member.memberspring.dto.MemberDTO;
import member.memberspring.entity.MemberEntity;
import member.memberspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberrepository;

    public void save(MemberDTO memberDTO){
        // save 메서드를 호출하기 위해서는 2가지를 해야함.
        // dto객체를 entity객체로 변환

        // 1. dto -> entity 변환
        // 2. repository save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberrepository.save(memberEntity);

        // repository save메서드 호출( 조건. entitiy객체를 넘겨줘야 함)
    }

    public MemberDTO login(MemberDTO memberDTO) {

        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        */
        Optional<MemberEntity> byUserId = memberrepository.findByUserid(memberDTO.getUserid());
        System.out.println("byUserId"+byUserId);
        if (byUserId.isPresent()) {
            // 여기 조회결과가 있다는 뜻이다.(해당 이름을 가진 회원 정보가 있다)
            MemberEntity memberEntity = byUserId.get(); // Optional로 감싸진 객체를 하나의 포장지를 벗겨내는 메서드인
            // get이라는 메서드가 있다.
            // get()을 이용하면 객체정보를 가져올 수 있다.

            // 엔티티에 담겨있는 pw가 DTO에 담겨있는 pw와 같은지 보자.
            if (memberEntity.getUserpw().equals(memberDTO.getUserpw()))
            {
                //  비밀번호가 일치
                // 일치했으니까 정보를 컨트롤러로 넘겨주어야 한다.
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }else{
                // 비밀번호 불일치(로그인실패)
                return null;
            }
        } else {
            //조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }
}

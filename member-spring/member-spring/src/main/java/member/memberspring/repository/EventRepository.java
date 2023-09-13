package member.memberspring.repository;


import member.memberspring.entity.EventEntity;
import member.memberspring.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    // 아이디로 회원 정보 조회, (select * from member_table where member_name=?)
    // 이정도의 쿼리가 나감
    // 고유 식별자를 사용하여 이벤트 엔터티 조회
    Optional<EventEntity> findById(Long id);


}


package member.memberspring.repository;


import member.memberspring.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회, 우리는 ID로 회원 정보 조회


    // 아이디로 회원 정보 조회, (select * from member_table where member_name=?)
    // 이정도의 쿼리가 나감
//    Optional<MemberEntity> findByuser_id(String user_id);




//    Optional<MemberEntity> findByUserId(String userId);
    Optional<MemberEntity> findByUserid(String userid);
}

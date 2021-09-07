package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)// 스프링과 관련된 테스트를 할거라고 junit한테 알려준다.
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    //tdd + tab //setting / Livetemplates
    @Test
    @Transactional //트랜잭션 어노테이션이 꼭 필요
    //@Rollback(false) 을 넣으면 롤백을 안하고 db에 값을 넣고 확인 할수있음
    @Rollback(false)
    public void testMember() throws Exception {

        Member member = new Member();
        member.setUsername("memberA");

        //when //Ctrl + Alt + V 변수뽑기 단축키
        Long saveId= memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMmeber == member "+ (findMember == member));

//트랜잭션이 테스트케이스에 있으면 테스트가 끝난후 바로 롤백해버린다. 말그대로 테스트니까 ㅎ


    }

}
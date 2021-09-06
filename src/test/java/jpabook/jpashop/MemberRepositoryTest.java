package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    public void testMember() throws Exception {

        Member member = new Member();
        member.setUsername("memberA");

        //when //Ctrl + Alt + V 변수뽑기 단축키
        Long saveId= memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());





    }

}
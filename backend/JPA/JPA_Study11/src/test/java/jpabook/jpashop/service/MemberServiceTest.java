package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void singup() throws Exception {
        Member member = new Member();
        member.setName("yount_tteen");

        Long saveId = memberService.join(member);

        // join()으로 Entity에 저장된 member와 findOne(saveId)를 통해 가져온 member가 같은 객체인지 검증
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class) // 해당 Exception이 발생하길 기대함
    public void dupMemberException() throws Exception {

        Member member1 = new Member();
        member1.setName("yount_tteen");

        Member member2 = new Member();
        member2.setName("yount_tteen");

        memberService.join(member1);
        memberService.join(member2); // 중복의 경우, 예외 발생

        fail("Thrown Exception");
    }
}

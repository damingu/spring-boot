package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.ArrayEquals;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository() ;

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring") ;

        repository.save(member) ;

        Member result = repository.findById(member.getId()).get() ;
        assertEquals(member, result);
        assertThat(member).isEqualTo(result) ;
//        System.out.println("result = " + (result == member));
    }
}

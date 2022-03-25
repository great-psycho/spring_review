package practice.practicezero.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.practicezero.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 Test 가 끝날때 이전값들을 클리어 해준다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test // 테스트 할떄 사용하는 어노테이션
    public void save() { // save 가 잘 되는지 테스트
        Member member = new Member(); // 선언해준다.
        member.setName("spring"); // 세팅해준다.

        repository.save(member); // 저장해준다.

        Member result = repository.findById(member.getId()).get(); // .get()으로 가져오는건 좋지는 않으나 테스트코드에서는 해볼만 하다.

        // 확인 방법 1
        Assertions.assertEquals(member, result);

        // 확인 방법 2
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}

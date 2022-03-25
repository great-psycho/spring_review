package practice.practicezero.repository;

import practice.practicezero.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // sequence: 0,1,2 등등 key값을 생성해 주는 친구이다.

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 자동으로 id 세팅
        store.put(member.getId(), member); // store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // store.get(id)가 null 값이어도 가능하게 해준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // loop를 돌려주는 역할
                .filter(member -> member.getName().equals(name)) // member.getName()이 이 파라미터로 들어온 name과 같은지 확인
                .findAny(); // 하나라도 찾으면 반환해 준다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // 내용을 클리어 해준다.
    public void clearStore() {
        store.clear();
    }
}

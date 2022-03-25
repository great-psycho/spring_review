package practice.practicezero.repository;

import practice.practicezero.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // 회원 id 가져오기
    Optional<Member> findByName(String name); // 회원 name 가져오기
    List<Member> findAll(); // List로 전부 가져오기
}

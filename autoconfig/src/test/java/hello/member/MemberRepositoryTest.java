package hello.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberRepository.initTable();
    }

    @Test
    void memberTest() {
        Member member = new Member("seunglo", "최승호");

        memberRepository.save(member);

        List<Member> members = memberRepository.findAll();
        Assertions.assertThat(members).hasSize(1);
    }
}

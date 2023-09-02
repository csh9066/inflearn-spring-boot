package hello.member;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

    private final JdbcTemplate template;

    public void initTable() {
        template.execute("create table member (member_id varchar primary key, name varchar)");
    }

    public void save(Member member) {
        template.update("insert into member (member_id, name) values (?, ?)",
                member.getMemberId(),
                member.getName());
    }

    public Member findById(String id) {
        return template.queryForObject(
                "select * from member where member_id = ?",
                BeanPropertyRowMapper.newInstance(Member.class),
                id);
    }

    public List<Member> findAll() {
        return template.query(
                "select * from member",
                BeanPropertyRowMapper.newInstance(Member.class));
    }
}

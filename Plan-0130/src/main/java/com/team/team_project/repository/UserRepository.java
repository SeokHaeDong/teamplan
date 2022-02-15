package com.team.team_project.repository;

import com.team.team_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> ,QuerydslPredicateExecutor<User> {
    public User findByCode(Long code);


    @Query(value = "select u.id, u.pw, u.nick from User u where u.id =:id")
    Object findById(@Param("id") String id);

    @Query(value = "select email, pw, id from User")
    List<Object[]> getalldata();

    @Query(value = "select u.id, u.email from User u where u.nick = :nick")
    Object findByNick(@Param("nick") String nick);

    @Query(value = "select u.id, u.email from User u where u.code = :code")
    Object findUserIdAndEmailByUserCode(@Param("code")Long code);

    // pw 변경 service method 에 사용 email 이 일치하면 해당 Email 을 return
    @Query(value = "select email from User")
    List<Object []> useEmailReturnCode();

    // pw 변경 servie method 에 사용 // id 가 일치하면 id return
    @Query(value = "select id from User where id = :id ")
    String  userIdRuturnCode(@Param("id")String id);


    // 비밀번호 변경 하기
    // String
    @Modifying
    @Transactional
    @Query(value = "update User set pw =:pw where id =:id")
    void changingPw(@Param("pw")String pw, @Param("id")String id);



}

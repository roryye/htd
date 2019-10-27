package cn.bunz.htd.repository;

import cn.bunz.htd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    @Query(nativeQuery = true, value = "select user_password from tb_user where user_name=?1")
    String findUserPasswordByUserName(String userName);

}

package net.skhu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

    User findByLoginName(String loginName);
    Page<User> findByLoginNameStartsWith(String loginName, Pageable pageable);
    Page<User> findByNameStartsWith(String loginName, Pageable pageable);
}

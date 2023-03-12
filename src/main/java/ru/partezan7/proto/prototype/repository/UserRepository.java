package ru.partezan7.proto.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.partezan7.proto.prototype.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

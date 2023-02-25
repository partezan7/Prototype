package ru.partezan7.proto.prototype.repository;

import org.springframework.data.repository.CrudRepository;
import ru.partezan7.proto.prototype.entity.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}

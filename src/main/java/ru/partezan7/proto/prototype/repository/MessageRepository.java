package ru.partezan7.proto.prototype.repository;

import org.springframework.data.repository.CrudRepository;
import ru.partezan7.proto.prototype.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
}

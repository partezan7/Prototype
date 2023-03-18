package ru.partezan7.proto.prototype.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.partezan7.proto.prototype.entity.Message;
import ru.partezan7.proto.prototype.entity.User;
import ru.partezan7.proto.prototype.repository.MessageRepository;

import java.util.Map;
import java.util.Optional;

@Controller
public class ProtoController {

    private final MessageRepository repository;

    public ProtoController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/main")
    public String mainPage(Map<String, Object> model) {
        Iterable<Message> messages = repository.findAll();
        model.put("messages", messages);
        return "main-page.html";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        repository.save(message);

        Iterable<Message> messages = repository.findAll();
        model.put("messages", messages);
        return "main-page.html";
    }

    @PostMapping("/filter")
    public String find(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if (filter == null || filter.isEmpty()) {
            messages = repository.findAll();
        } else {
            messages = repository.findByTag(filter);
        }
        model.put("messages", messages);
        return "main-page.html";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id, Map<String, Object> model) {
        long parseId = Long.parseLong(id);
        Optional<Message> byId = repository.findById(parseId);
        if (byId.isPresent()) repository.deleteById(parseId);

        Iterable<Message> messages = repository.findAll();
        model.put("messages", messages);
        return "main-page.html";
    }
}

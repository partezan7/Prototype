package ru.partezan7.proto.prototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.partezan7.proto.prototype.entity.Message;
import ru.partezan7.proto.prototype.repository.MessageRepository;

import java.util.Map;

@Controller
public class ProtoController {
    @Autowired
    private MessageRepository repository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "start-page";
    }

    @GetMapping("/main")
    public String mainPage(Map<String, Object> model) {
        Iterable<Message> messages = repository.findAll();
        model.put("messages", messages);
        return "main-page.html";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
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
}

package com.project.backend.aula6;

import com.project.backend.aula6.service.MessageService;
import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private List<String> messages = new ArrayList<>();

    @GetMapping
    public List<String> list() {
        return messages;
    }

    @PostMapping
    public String add(@RequestBody String message) {
        messages.add(message);
        return "Mensagem adicionada com sucesso";
    }
    /*
    @PutMapping("/{index}")
    public String update(@RequestBody String message, @PathVariable int index) {
        if (index >= 0 && index < messages.size()) {
            messages.set(index, message);
            return "Mensagem atualizada com sucesso!";
        }
        return "Índice inválido ou array vazio!";
    }
    */
    @PutMapping("/{index}")
    public String update(@RequestBody String message, @PathVariable int index) {
        return new MessageService().update(message, index);
    }

    @DeleteMapping("/{index}")
    public String remover(@PathVariable int index) {
        if (index >= 0 && index < messages.size()) {
            messages.remove(index);
            return "Mensagem removida!";
        }
        return "Índice inválido ou array vazio!";
    }
}

package com.project.backend.aula6.service;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    private List<String> messages = new ArrayList<>();
    public String update(String message, int index) {
        if (index >= 0 && index < messages.size()) {
            messages.set(index, message);
            return "Mensagem atualizada com sucesso!";
        }
        return "Índice inválido ou array vazio!";
    }
}

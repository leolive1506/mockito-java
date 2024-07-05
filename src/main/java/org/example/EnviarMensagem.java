package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnviarMensagem {
    private List<Mensagem> mensagens = new ArrayList<>();

    public List<Mensagem> getMensagens() {
        return Collections.unmodifiableList(mensagens);
    }

    public void add(Mensagem mensagem) {
        if (mensagem == null) {
            throw new IllegalArgumentException("Mensagem nao pode ser nula");
        }

        logAntes();
        this.mensagens.add(mensagem);
        logDepois();
    }

    public void logAntes() {
        System.out.println("log antes");
    }

    public void logDepois() {
        System.out.println("log depois");
    }
}

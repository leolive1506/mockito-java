package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions. *;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTest {

    @Spy
    private EnviarMensagem enviarMensagem;

    @Test
    void verificarComportamentoDaClasse() {
        Mockito.verifyNoInteractions(enviarMensagem);
        InOrder order = Mockito.inOrder(enviarMensagem);

        var msg = new Mensagem("mensagem test");

        enviarMensagem.add(msg);

        Mockito.verify(enviarMensagem).add(msg);

        // aceitar qualquer valor
        // order.verify(enviarMensagem).add(ArgumentMatchers.any(Mensagem.class));
        order.verify(enviarMensagem).add(msg);
        order.verify(enviarMensagem).logAntes();
        order.verify(enviarMensagem).logDepois();

        assertFalse(enviarMensagem.getMensagens().isEmpty());
    }

    @Test
    void validarQuantidadeChamadas() {
        enviarMensagem.add(new Mensagem("mensagem 1"));
        enviarMensagem.add(new Mensagem("mensagem 2"));

        Mockito.verify(enviarMensagem, Mockito.times(2)).add(ArgumentMatchers.any(Mensagem.class));
    }
}

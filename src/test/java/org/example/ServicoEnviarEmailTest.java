package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ServicoEnviarEmailTest {

    @Mock
    private PlataformaDeEnvio plataformaDeEnvio;

    @InjectMocks
    private ServicoEnviarEmail servico;

    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviados() {
        var email = "test@gmail.com";
        var mensagem = "Ola teste mensagem";
        var formatoHtml = false;

        servico.send(email, mensagem, formatoHtml);

        Mockito.verify(plataformaDeEnvio).send(captor.capture());

        Email emailCapturado = captor.getValue();

        assertEquals(email, emailCapturado.getEmail());
        assertEquals(mensagem, emailCapturado.getMensagem());
        assertEquals(Formato.TEXTO, emailCapturado.getFormato());
    }
}

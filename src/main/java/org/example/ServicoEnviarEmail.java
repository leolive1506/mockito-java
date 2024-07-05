package org.example;

public class ServicoEnviarEmail {
    private PlataformaDeEnvio plataformaDeEnvio;

    void send(String email, String mensagem, boolean formatoHtml) {
        var newEmail = new Email(email, mensagem, formatoHtml ? Formato.HTML : Formato.TEXTO);

        plataformaDeEnvio.send(newEmail);
    }
}

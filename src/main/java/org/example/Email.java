package org.example;

public class Email {

    private String email;
    private String mensagem;
    private Formato formato;

    public Email(String email, String mensagem, Formato formato) {
        this.email = email;
        this.mensagem = mensagem;
        this.formato = formato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
}

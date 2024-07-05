package org.example;

import java.time.LocalDate;

public class CadastrarPessoa {
    private ApiDosCorreios apiDosCorreios;

    public CadastrarPessoa(final ApiDosCorreios apiDosCorreios) {
        this.apiDosCorreios = apiDosCorreios;
    }

    public Pessoa execute(String nome, String docoumento, LocalDate nascimento, String cep) {
        var pessoa = new Pessoa(nome, docoumento, nascimento);
        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscarDadosPorCep(cep);

        pessoa.setEndereco(dadosLocalizacao);

        return pessoa;
    }

    public ApiDosCorreios getApiDosCorreios() {
        return apiDosCorreios;
    }

    public void setApiDosCorreios(ApiDosCorreios apiDosCorreios) {
        this.apiDosCorreios = apiDosCorreios;
    }
}

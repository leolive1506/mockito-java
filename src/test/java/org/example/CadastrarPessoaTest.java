package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {
    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosCadastro() {
        var cep = "123123";
        Mockito
                .when(apiDosCorreios.buscarDadosPorCep(cep))
                .thenReturn(new DadosLocalizacao("MG", "Cidade", "rua teste", "apto", "centro"));

        var pessoa = cadastrarPessoa.execute("leonardo", "12341234", LocalDate.now(), cep);

        assertEquals("leonardo", pessoa.getNome());
        assertEquals("MG", pessoa.getEndereco().getUf());
        assertEquals("Cidade", pessoa.getEndereco().getCidade());
        assertEquals("rua teste", pessoa.getEndereco().getLogradouro());
    }
}

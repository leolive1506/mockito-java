package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
        var cep = "1231f23";
        Mockito
                .when(apiDosCorreios.buscarDadosPorCep(cep))
                .thenReturn(new DadosLocalizacao("MG", "Cidade", "rua teste", "apto", "centro"));

        var pessoa = cadastrarPessoa.execute("leonardo", "12341234", LocalDate.now(), cep);

        assertEquals("leonardo", pessoa.getNome());
        assertEquals("MG", pessoa.getEndereco().getUf());
        assertEquals("Cidade", pessoa.getEndereco().getCidade());
        assertEquals("rua teste", pessoa.getEndereco().getLogradouro());
    }

    @Test
    void lancarExeception() {
        Mockito.when(apiDosCorreios.buscarDadosPorCep(ArgumentMatchers.anyString())).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.execute("leonardo", "12341234", LocalDate.now(), "1234"));
    }

    @Test
    void lancarExeception2() {
        Mockito.doThrow(IllegalArgumentException.class)
            .when(apiDosCorreios)
            .buscarDadosPorCep(ArgumentMatchers.anyString());

        assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.execute("leonardo", "12341234", LocalDate.now(), "1234"));
    }
}

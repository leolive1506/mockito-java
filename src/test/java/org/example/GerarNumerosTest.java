package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GerarNumerosTest {
    @Test
    void testarGerarComTamanhoDefinido() {
        MockedStatic<GerarNumeros> gerador = Mockito.mockStatic(GerarNumeros.class);

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        gerador.when(() -> GerarNumeros.gerarNumerosAleatorios(ArgumentMatchers.anyInt()))
                .thenReturn(integers);

        Assertions.assertEquals(integers, GerarNumeros.gerarNumerosAleatorios(8));
    }

    @Test
    void testarGerarSemTamanhoDefinido() {
        MockedStatic<GerarNumeros> gerador = Mockito.mockStatic(GerarNumeros.class);

        List<Integer> integers = List.of(10, 9, 8, 6);

        gerador.when(GerarNumeros::gerarNumerosAleatorios).thenReturn(integers);

        Assertions.assertEquals(integers, GerarNumeros.gerarNumerosAleatorios());
    }

}

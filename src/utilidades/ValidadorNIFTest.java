package utilidades;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorNIFTest {
    @ParameterizedTest
    @ValueSource(strings = {"46479277A", "36233093C", "45549533B", "82961859P", "20461066J"})
    void devuelveTrueConNifsValidos(String nif) {
        assertTrue(ValidadorNIF.ejecutar(nif));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678X", "0123456A", "123456789A", "ABCDEFGHJ", "12345678$"})
    void devuelveFalseConNifsInvalidos(String nif) {
        assertFalse(ValidadorNIF.ejecutar(nif));
    }
}
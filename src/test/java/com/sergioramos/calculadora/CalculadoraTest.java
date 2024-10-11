package com.sergioramos.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {

	private Calculadora calculadora;
	
	@BeforeEach
	void crearCalculadora() {
		calculadora = new Calculadora();
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2",
		"2,5",
		"-3,-3",
		"-5,-8",
		"2,-3"
	})
	void sumaNoLanzaNingunaExcepcion(double x, double y) {
		assertDoesNotThrow(() -> calculadora.sumar(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2,4",
		"2,5,7",
		"-3,-3,-6",
		"-5,-8,-13",
		"2,-3,-1"
	})
	void sumaFuncionaCorrectamente(double x, double y, double esperado) {
		assertEquals(esperado, calculadora.sumar(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2",
		"2,5",
		"-3,-3",
		"-5,-8",
		"2,-3"
	})
	void restaNoLanzaNingunaExcepcion(double x, double y) {
		assertDoesNotThrow(() -> calculadora.restar(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2,0",
		"2,5,-3",
		"-3,-3,0",
		"-5,-8,3",
		"2,-3,5"
	})
	void restaFuncionaCorrectamente(double x, double y, double esperado) {
		assertEquals(esperado, calculadora.restar(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2",
		"2,5",
		"-3,-3",
		"-5,-8",
		"2,-3"
	})
	void multiplicacionNoLanzaNingunaExcepcion(double x, double y) {
		assertDoesNotThrow(() -> calculadora.multiplicar(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2,4",
		"2,5,10",
		"-3,-3,9",
		"-5,-8,40",
		"2,-3,-6"
	})
	void multiplicacionFuncionaCorrectamente(double x, double y, double esperado) {
		assertEquals(esperado, calculadora.multiplicar(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2",
		"2,5",
		"-3,-3",
		"-5,-8",
		"2,-3"
	})
	void divisionNoLanzaNingunaExcepcion(double x, double y) {
		assertDoesNotThrow(() -> calculadora.dividir(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2,2,1",
		"2,5,0.4",
		"-3,-3,1",
		"-5,-8,0.625",
		"2,-3,-0.66666667"
	})
	void divisionFuncionaCorrectamente(double x, double y, double esperado) {
		assertEquals(esperado, calculadora.dividir(x, y), 0.0001);
	}
	
	@ParameterizedTest
	@CsvSource({
		"0,0",
		"4,0",
		"-8,0",
		"4.9,0",
		"-8.1,0"
	})
	void divisionLanzaUnaExcepcionCuandoSeDividePorCero(double x, double y) {
		ArithmeticException e = assertThrows(ArithmeticException.class, () -> calculadora.dividir(x, y));
		assertEquals("División por cero", e.getMessage());
	}

}

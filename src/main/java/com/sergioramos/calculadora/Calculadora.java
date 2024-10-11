package com.sergioramos.calculadora;

public class Calculadora {
	
	public double sumar(double x, double y) {
		return x + y;
	}
	
	public double restar(double x, double y) {
		return x - y;
	}
	
	public double multiplicar(double x, double y) {
		return x * y;
	}
	
	public double dividir(double x, double y) {
		if(y == 0) {
			throw new ArithmeticException("División por cero");
		}
		return x / y;
	}

}

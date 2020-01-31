package services;

public class Operation {
	public double addition(double a, double b) {
		return a+b;
	}
	
	public double multiplication(double a, double b) {
		return a*b;
	}
	
	public double division(double a, double b) {
		return a/b;
	}
	
	public double calcul(double a, double b, String operation) {
		switch (operation) {
		case "addition":
			return addition(a, b);
		case "multiplication":
			return multiplication(a, b);
		case "division":
			return division(a, b);
		default:
			return 0;
		}
	}
}

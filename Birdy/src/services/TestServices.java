package services;

public class TestServices {

	public static void main(String[] args) {
		Operation o = new Operation();
		System.out.println("Addition de 5 et 7 " + o.addition(5, 7));
		System.out.println("Multiplication de 5 et 7 " + o.multiplication(5, 7));
		System.out.println("Division de 5 et 7 " + o.division(5, 7));
		
		System.out.println("Addition de 5 et 7 " + o.calcul(5, 7, "addition"));	
		System.out.println("Multiplication de 5 et 7 " + o.calcul(5, 7, "multiplication"));	
		System.out.println("Division de 5 et 7 " + o.calcul(5, 7, "division"));	
		
		System.out.println("Inconnue de 5 et 7 " + o.calcul(5, 7, "inconnue"));	
	}

}

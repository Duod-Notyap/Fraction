package main;

public class Main {
	public static void main(String[] args) {
		Fraction a = new Fraction(4, 5);
		Fraction b = new Fraction(3, 5);
		Fraction c = new Fraction(4, 20);
		Fraction d = new Fraction(22, 7);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(Fraction.toString(c));
		System.out.println(a.divi(b).toString());
		System.out.println(a.mult(c).toString());
		System.out.println(c.reduce().toString());
		System.out.println(b.add(c).toString());
		System.out.println(d.toBigDecimal().toString());
	}
	
}

package main;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Fraction {
	public int num;
	public int den;
	public Fraction(int a, int b) {
		this.num = a;
		this.den = b;
	}

	/**
	 * adds this and a
	 * @param a   frac to add
	 * @return    new fraction that is the sum unreduced
	 */
	public Fraction add(Fraction a) {
		return new Fraction(this.num*a.den+this.den*a.num, this.den*a.den);
	}
	
	/**
	 * adds two fractions a and b
	 * @param a   frac 1
	 * @param b   frac 2
	 * @return    new fraction that is the sum unreduced
	 */
	public static Fraction add(Fraction a, Fraction b) {
		return new Fraction(a.num*b.den+a.den*b.num, a.den*b.den);
	}
	
	/**
	 * subtracts a from this
	 * @param a  frac to subtract
	 * @return   new fraction unreduced
	 */
	public Fraction subt(Fraction a) {
		return new Fraction(this.num*a.den-this.den*a.num, this.den*a.den);
	}
	
	/**
	 * subtracts frac b from frac a
	 * @param a  frac 1
	 * @param b  frac 2
	 * @return   new fraction unreduced
	 */
	public static Fraction subt(Fraction a, Fraction b) {
		return new Fraction(a.num*b.den-a.den*b.num, a.den*b.den);
	}
	
	/**multiplies two Fractions
	 * @param a  Fraction to multiply this by
	 * @return   new Fraction that is the product unreduced
	 */
	public Fraction mult(Fraction a) {
		return new Fraction(this.num*a.num, this.den*a.den);
	}
	
	/**multiplies two Fractions
	 * @param a  one multiple
	 * @param b  two multiple
	 * @return   new Fraction that is the product unreduced
	 */
	public static Fraction mult(Fraction a, Fraction b) {
		return new Fraction(a.num*b.num, a.den*b.den);
	}
	
	/**divide fraction a by fraction b
	 * @param a  divisor
	 * @return   new Fraction that is divided unreduced
	 */
	public Fraction divi(Fraction a) {
		return new Fraction(this.num*a.den, this.den*a.num);
	}
	
	/**divide fraction a by fraction b
	 * @param a  dividend
	 * @param b  divisor
	 * @return   new Fraction that is divided unreduced
	 */
	public static Fraction divi(Fraction a, Fraction b) {
		return new Fraction(a.num*b.den, a.den*b.num);
	}
	
	/**
	 * returns value in decimal form
	 * returns as type double
	 * @return   double of value
	 */
	public double value() {
		return (double)(this.num/this.den);
	}
	
	/**
	 * returns value in decimal form
	 * returns as type double
	 * @param a  Fraction to evaluate
	 * @return   double of value
	 */
	public static double value(Fraction a) {
		return (double)(a.num/a.den);
	}
	
	/**
	 * returns the fraction as a string e.g: 1/5 -> "1/5"
	 * @return    String in format "<num>/<den>"
	 */
	public String toString() {
		return String.format("%1$d/%2$d", this.num, this.den);
	}
	
	/**
	 * returns the fraction as a string e.g: 1/5 -> "1/5"
	 * @param a   the fraction to return String of
	 * @return    String in format "<num>/<den>"
	 */
	public static String toString(Fraction a) {
		return String.format("%1$d/%2$d", a.num, a.den);
	}
	
	/**
	 * reduces or simplifies fraction e.g: 4/20 -> 1/5
	 * @return   a reduced Fraction
	 */
	public Fraction reduce() {
		int gcd = findGCD(this.num, this.den);
		return new Fraction(this.num/gcd, this.den/gcd);
	}
	
	/**
	 * reduces or simplifies fraction e.g: 4/20 -> 1/5
	 * @param a  Fraction to reduce
	 * @return   a reduced Fraction
	 */
	public static Fraction reduce(Fraction a) {
		int gcd = findGCD(a.num, a.den);
		return new Fraction(a.num/gcd, a.den/gcd);
		
	}
	
	/**
	 * Eulers algorithm - finds GCD
	 * @param a  num 1
	 * @param b  num 2
	 * @return   the gcd
	 */
	public static int findGCD(int a, int b) {
		if(b==0) {
			return a;
		}else { 
			return findGCD(b, a%b);
		}
	}
	
	/**
	 * ran by this.toBigDecimal
	 * @return returns a BigDecimal rounded to 100 places
	 */
	public BigDecimal toBigDecimal() {
		BigDecimal a = new BigDecimal((double)this.num);
		BigDecimal b = new BigDecimal((double)this.den);
		return a.divide(b, 100, RoundingMode.HALF_UP);
	}
	
	/**
	 * This method can be called as Fraction.toBigDecimal
	 * @param fr  the fraction to return
	 * @return    returns a BigDecimal rounded to 100 decimals
	 */
	public static BigDecimal toBigDecimal(Fraction fr) {
		BigDecimal a = new BigDecimal((double)fr.num);
		BigDecimal b = new BigDecimal((double)fr.den);
		return a.divide(b, 100, RoundingMode.HALF_UP);
	}
	
	/**
	 * This returns the value of a Fraction as a BigDecimal for extra precision
	 * @param round_to  the length to round to 
	 * @return          returns a BigDecimal rounded to round_to
	 */
	public BigDecimal toBigDecimal(int round_to) {
		BigDecimal a = new BigDecimal((double)this.num);
		BigDecimal b = new BigDecimal((double)this.den);
		return a.divide(b, round_to, RoundingMode.HALF_UP);
	}
	
	/**
	 * 
	 * @param fr        the Fraction to return
	 * @param round_to  the distance to round to 
	 * @return
	 */
	public static BigDecimal toBigDecimal(Fraction fr, int round_to) {
		BigDecimal a = new BigDecimal((double)fr.num);
		BigDecimal b = new BigDecimal((double)fr.den);
		return a.divide(b, round_to, RoundingMode.HALF_UP);
	}
	
	/**
	 * replaces the numerator with the denominator and vice versa
	 * or inverts the fraction
	 * @return returns   a new fraction with inverted values
	 */
	public Fraction invert() {
		return new Fraction(this.den, this.num);
	}
	
	/**
	 * replaces the numerator with the denominator and vice versa
	 * or inverts the fraction
	 * @param a  the fraction to return inverse of
	 * @return   a new fraction with inverted values
	 */
	public Fraction invert(Fraction a) {
		return new Fraction(a.den, a.num);
	}
}

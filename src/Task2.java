public class Task2 {
/*Створити абстрактний базовий клас Pair з абстрактними арифметичними
операціями додавання, віднімання та множення. Створити похідні класи
Complex (комплексне число) і Rational (раціональний дріб) з власною
реалізацією арифметичних операцій.*/
    public static void main(String[] args) {
        Complex complex1 = new Complex(3, 2);
        Complex complex2 = new Complex(1, 4);

        System.out.println("Complex1: " + complex1);
        System.out.println("Complex2: " + complex2);

        Complex sum = (Complex) complex1.add(complex2);
        System.out.println("Sum: " + sum);

        Complex difference = (Complex) complex1.subtract(complex2);
        System.out.println("Difference: " + difference);

        Complex product = (Complex) complex1.multiply(complex2);
        System.out.println("Product: " + product);

        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(3, 4);

        System.out.println("Rational1: " + rational1);
        System.out.println("Rational2: " + rational2);

        Rational sumRational = (Rational) rational1.add(rational2);
        System.out.println("Sum: " + sumRational);

        Rational differenceRational = (Rational) rational1.subtract(rational2);
        System.out.println("Difference: " + differenceRational);

        Rational productRational = (Rational) rational1.multiply(rational2);
        System.out.println("Product: " + productRational);
    }
}
abstract class Pair {
    public abstract Pair add(Pair other);
    public abstract Pair subtract(Pair other);
    public abstract Pair multiply(Pair other);
}

class Complex extends Pair {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public Pair add(Pair other) {
        if (other instanceof Complex) {
            Complex otherComplex = (Complex) other;
            return new Complex(this.real + otherComplex.real, this.imaginary + otherComplex.imaginary);
        }
        return null; 
    }

    @Override
    public Pair subtract(Pair other) {
        if (other instanceof Complex) {
            Complex otherComplex = (Complex) other;
            return new Complex(this.real - otherComplex.real, this.imaginary - otherComplex.imaginary);
        }
        return null; 
    }

    @Override
    public Pair multiply(Pair other) {
        if (other instanceof Complex) {
            Complex otherComplex = (Complex) other;
            double resultReal = this.real * otherComplex.real - this.imaginary * otherComplex.imaginary;
            double resultImaginary = this.real * otherComplex.imaginary + this.imaginary * otherComplex.real;
            return new Complex(resultReal, resultImaginary);
        }
        return null; 
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
class Rational extends Pair {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Pair add(Pair other) {
        if (other instanceof Rational) {
            Rational otherRational = (Rational) other;
            int resultNumerator = this.numerator * otherRational.denominator + otherRational.numerator * this.denominator;
            int resultDenominator = this.denominator * otherRational.denominator;
            return new Rational(resultNumerator, resultDenominator);
        }
        return null; 
    }

    @Override
    public Pair subtract(Pair other) {
        if (other instanceof Rational) {
            Rational otherRational = (Rational) other;
            int resultNumerator = this.numerator * otherRational.denominator - otherRational.numerator * this.denominator;
            int resultDenominator = this.denominator * otherRational.denominator;
            return new Rational(resultNumerator, resultDenominator);
        }
        return null; 
    }

    @Override
    public Pair multiply(Pair other) {
        if (other instanceof Rational) {
            Rational otherRational = (Rational) other;
            int resultNumerator = this.numerator * otherRational.numerator;
            int resultDenominator = this.denominator * otherRational.denominator;
            return new Rational(resultNumerator, resultDenominator);
        }
        return null; 
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
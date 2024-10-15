public interface Pair {
    Pair add(Pair other);
    Pair subtract(Pair other);
    Pair multiply(Pair other);
    String toString();
    boolean equals(Object obj);
}

class Complex implements Pair {
    private final double realPart;
    private final double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public Complex add(Pair other) {
        Complex otherComplex = (Complex) other;
        return new Complex(this.realPart + otherComplex.realPart, this.imaginaryPart + otherComplex.imaginaryPart);
    }

    @Override
    public Complex subtract(Pair other) {
        Complex otherComplex = (Complex) other;
        return new Complex(this.realPart - otherComplex.realPart, this.imaginaryPart - otherComplex.imaginaryPart);
    }

    @Override
    public Complex multiply(Pair other) {
        Complex otherComplex = (Complex) other;
        double realPart = this.realPart * otherComplex.realPart - this.imaginaryPart * otherComplex.imaginaryPart;
        double imaginaryPart = this.realPart * otherComplex.imaginaryPart + this.imaginaryPart * otherComplex.realPart;
        return new Complex(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Complex complex = (Complex) obj;
        return Double.compare(complex.realPart, realPart) == 0 && Double.compare(complex.imaginaryPart, imaginaryPart) == 0;
    }
}

class Rational implements Pair {
    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }

    private Rational simplify() {
        int greatestCommonDivisor = greatestCommonDivisor(numerator, denominator);
        return new Rational(numerator / greatestCommonDivisor, denominator / greatestCommonDivisor);
    }

    @Override
    public Rational add(Pair other) {
        Rational o = (Rational) other;
        int newNumerator = this.numerator * o.denominator + o.numerator * this.denominator;
        int newDenominator = this.denominator * o.denominator;
        return new Rational(newNumerator, newDenominator).simplify();
    }

    @Override
    public Rational subtract(Pair other) {
        Rational o = (Rational) other;
        int newNumerator = this.numerator * o.denominator - o.numerator * this.denominator;
        int newDenominator = this.denominator * o.denominator;
        return new Rational(newNumerator, newDenominator).simplify();
    }

    @Override
    public Rational multiply(Pair other) {
        Rational o = (Rational) other;
        return new Rational(this.numerator * o.numerator, this.denominator * o.denominator).simplify();
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rational rational = (Rational) obj;
        Rational simplifiedThis = this.simplify();
        Rational simplifiedOther = rational.simplify();
        return simplifiedThis.numerator == simplifiedOther.numerator && simplifiedThis.denominator == simplifiedOther.denominator;
    }
}

abstract class DefaultPair {
    public abstract DefaultPair add(DefaultPair other);
    public abstract DefaultPair subtract(DefaultPair other);
    public abstract DefaultPair multiply(DefaultPair other);
    public abstract String toString();
    public abstract boolean equals(Object obj);
}

class DefaultComplex extends DefaultPair {
    private final double realPart;
    private final double imaginaryPart;

    public DefaultComplex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public DefaultComplex add(DefaultPair other) {
        DefaultComplex otherComplex = (DefaultComplex) other;
        return new DefaultComplex(this.realPart + otherComplex.realPart, this.imaginaryPart + otherComplex.imaginaryPart);
    }

    @Override
    public DefaultComplex subtract(DefaultPair other) {
        DefaultComplex otherComplex = (DefaultComplex) other;
        return new DefaultComplex(this.realPart - otherComplex.realPart, this.imaginaryPart - otherComplex.imaginaryPart);
    }

    @Override
    public DefaultComplex multiply(DefaultPair other) {
        DefaultComplex otherComplex = (DefaultComplex) other;
        double realPart = this.realPart * otherComplex.realPart - this.imaginaryPart * otherComplex.imaginaryPart;
        double imaginaryPart = this.realPart * otherComplex.imaginaryPart + this.imaginaryPart * otherComplex.realPart;
        return new DefaultComplex(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DefaultComplex complex = (DefaultComplex) obj;
        return Double.compare(complex.realPart, realPart) == 0 && Double.compare(complex.imaginaryPart, imaginaryPart) == 0;
    }
}

class DefaultRational extends DefaultPair {
    private final int numerator;
    private final int denominator;

    public DefaultRational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }

    private DefaultRational simplify() {
        int greatestCommonDivisor = greatestCommonDivisor(numerator, denominator);
        return new DefaultRational(numerator / greatestCommonDivisor, denominator / greatestCommonDivisor);
    }

    @Override
    public DefaultRational add(DefaultPair other) {
        DefaultRational o = (DefaultRational) other;
        int newNumerator = this.numerator * o.denominator + o.numerator * this.denominator;
        int newDenominator = this.denominator * o.denominator;
        return new DefaultRational(newNumerator, newDenominator).simplify();
    }

    @Override
    public DefaultRational subtract(DefaultPair other) {
        DefaultRational o = (DefaultRational) other;
        int newNumerator = this.numerator * o.denominator - o.numerator * this.denominator;
        int newDenominator = this.denominator * o.denominator;
        return new DefaultRational(newNumerator, newDenominator).simplify();
    }

    @Override
    public DefaultRational multiply(DefaultPair other) {
        DefaultRational o = (DefaultRational) other;
        return new DefaultRational(this.numerator * o.numerator, this.denominator * o.denominator).simplify();
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DefaultRational rational = (DefaultRational) obj;
        DefaultRational simplifiedThis = this.simplify();
        DefaultRational simplifiedOther = rational.simplify();
        return simplifiedThis.numerator == simplifiedOther.numerator && simplifiedThis.denominator == simplifiedOther.denominator;
    }
}

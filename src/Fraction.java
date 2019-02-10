// An interface for performing arithmetic on
// rational numbers as fractions.

public interface Fraction extends Comparable<Fraction> {
  int getNumerator();
  int getDenominator();
  Fraction plus(Fraction b);
  Fraction subtract(Fraction b);
  Fraction multiply(Fraction b);
  Fraction divide(Fraction b);
  Fraction powerOfN(int n);
  boolean equals(Fraction other);
  String toString();
}

# Problem Set 5
## Due Thursday, February 14 at 11:59pm
---

For this problem set, you will be implementing an interface. You will get the opportunity to work with 

The interface you will be implemented is a specification for carrying out mathematical operations on fractions (a.k.a. rational numbers). You are going to create a class that has two members variables of type `long`: one representing the numerator of the fraction and one representing the denominator of the fraction. 

The methods you write will perform arithmetic operations with fractions just the way you did in elementary school. For adding and subtracting, you need to ensure that the denominators are the same. To multiply, you multiply the two numerators to get the new numerator, and multiply the two denominators to get the new denominator. To divide, you flip the second fraction over and multiply. Of course, like in elementary school, you have to reduce your fractions to lowest terms. And you will always return another `Fraction` and never a decimal. (Hopefully, this is ringing a few bells. If not, Google it.) 

## The `Fraction` interface

Your ADT for immutable rational numbers, which you will write in `FractionClass.java`, should implement the following Java specification, which is contained in the `Fraction.java` interface:

```java
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
```

The notation `extends Comparable<Rational>` means that an implementation of the `Rational` interface requires everything listed explicitly between the braces `{...}` but **also** whatever is specified in the `Comparable` interface. The `Comparable` interface is an important built-in interface from `java.lang` which has one method:

```java
public interface Comparable<T> {
  int compareTo(T other);
}
```

Here `T` is a *type variable* and the notation `Comparable<Fraction>` should be understood as plugging in the type `Fraction` for the type variable `T` in the above. Since the result of that substitution is

```java
int compareTo(Fraction other);
```

your implementation of the `Fraction` interface

```java
public class FractionClass implements Fraction {
  ...
}
```

will need to inplement: (1) all the methods in the `Fraction` interface; (2) the `compareTo()` method from the `Comparable` interface; and (3) 

I have provided code from SW for least common multiple (`lcm`), which you can use to find the lowest common denominator, and greatest common divisor (`gcd`), which you'll find helpful when reducing fractions.

### Unit testing

The `main()` method runs some **unit tests**, which you can use to determine whether you are doing things correctly. When you run your code and uncomment what is in the main method, you should see the output that is indicated in the comments to the right of each method call in the main method.

You must provide **2 additional unit tests of the mathetmatical operations** using different rational numbers. Make your code look like the code provided for unit testing in `main()`. Specifically, in the comments, indicate what the expected output should be.

When you're all done, please commit and push your work to your personal ps2 repository with the message "Final - please grade".

The TAs will review and run your code. Note that in addition to running your unit tests, they might try a few of their own. It's a good idea to do some error checking!

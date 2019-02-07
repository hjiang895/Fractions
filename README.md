# Problem Set 5
## Due Thursday, February 14 at 11:59pm
---

For this problem set, you will be implementing an interface. You will also get the opportunity to write your own `compareTo()` method, to work with for loops, to learn about polymorphism, and to practice writing a constructor.

The interface you will be implementing is a specification for carrying out mathematical operations on fractions (a.k.a. rational numbers). You are going to create a class implementing this interface that has two instance variables of type `long`: one representing the numerator of the fraction and one representing the denominator of the fraction. 

The methods you write will perform arithmetic operations with fractions just the way you did in elementary school. For adding and subtracting, you need to ensure that the denominators are the same. To multiply, you multiply the two numerators to get the new numerator, and multiply the two denominators to get the new denominator. To divide, you flip the second fraction over and multiply. Of course, like in elementary school, you have to reduce your fractions to lowest terms! And you will always return another `Fraction` and never a decimal.

## The `Fraction` interface

The Java interface you will be implementing has the following specification:

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

The notation `extends Comparable<Fraction>` means that an implementation of the `Fraction` interface requires everything listed expicitly in the interface **and also** whatever is specified in the `Comparable` interface. The `Comparable` interface is an important built-in interface from `java.lang` which has one method:

```java
public interface Comparable<T> {
  int compareTo(T other);
}
```

Above you see `T`, which is a *type variable*. The notation `Comparable<Fraction>` should be understood as plugging in the type `Fraction` for the type variable `T` in the above. The result of that substitution in your code will be:

```java
int compareTo(Fraction other);
```
**You do not need to modify the interface in any way. For this problem set, you are just implementing this interface.**

## The `FractionClass` implementation of the `Fraction` interface

You will implement the `Fraction.java` interface in a class called `FractionClass.java`. `FractionClass.java` will need to implement: (1) all the methods in the `Fraction` interface; (2) the `compareTo()` method from the `Comparable` interface, as shown above; (3) a constructor f; and (4) a main method for testing your code.

### Unit testing

The `main()` method of `FractionClass.java` runs some *unit tests*, which you can use to determine whether you are doing things correctly. When you run your code and uncomment what is in the main method, you should see the output that is indicated in the comments to the right of each method call in the main method.

You must provide **2 additional unit tests of the mathematical operations** using different fractions. Make your code look like the code provided for unit testing in `main()`. Specifically, in the comments, indicate what the expected output should be.

### Helper code
In the `FractionClass.java` file, I have provided some code for finding the least common multiple (`lcm`) and greatest common divisor (`gcd`), which you may find helpful.

---

## Pushing and verifying your submission

Once your code works to your satisfaction, push `FractionClass.java` to your personal master repo on the GitHub Classroom site, as you have done for your previous problem sets. Use the commit message "READY FOR GRADING" so we know you are done. 

As always, you can check to see if it worked by going to your account on GitHub and checking to see if it was updated and whether the files have changed in the way you expected. This is your responsibility.

---

## Important notes on grading

1. The only acceptable way to submit is through GitHub. If you do not submit via GitHub, you will get a 0.

2. The `FractionClass.java` file **must be in the `src` directory**. You will lose 2 points if the file is in the wrong directory. The best way to make sure it is in the right place is to never ever move them in the first place.

3. Your code must compile. If a class does not compile, you will get a 0. If you are struggling and you aren't able to get in touch with me or the TAs, any TAs in the lab can help you compile your code.

4. The TAs will review and run your code. Note that in addition to running your unit tests, they will try a few of their own. It's a good idea to do some error checking to avoid any surprises during grading.

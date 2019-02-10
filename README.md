# Problem Set 5
## Due Thursday, February 21 at 11:59pm
---

For this problem set, you will be implementing an interface. You will also get the opportunity to write your own `compareTo()` method, to work with for loops, to learn about polymorphism, and to practice writing a constructor.

The interface you will be implementing is a specification for carrying out mathematical operations on fractions (a.k.a. rational numbers). You are going to create a class implementing this interface that has two instance variables of type `long`: one representing the numerator of the fraction and one representing the denominator of the fraction. 

The methods you write will perform arithmetic operations with fractions just the way you did in elementary school. For adding and subtracting, you need to ensure that the denominators are the same. To multiply, you multiply the two numerators to get the new numerator, and multiply the two denominators to get the new denominator. To divide, you flip the second fraction over and multiply. Of course, like in elementary school, you have to reduce your fractions to lowest terms! And you will always return another `Fraction` and never a decimal.

## The `Fraction` interface

**Note: You do not need to modify the `Fraction` interface in any way. You just need to implement the interface, as descibed in the next section and in the code for `FractionClass.java`.**

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

This is a new kind of interface for us because it extends another interface! The notation `extends Comparable<Fraction>` means that an implementation of the `Fraction` interface requires everything listed expicitly in the `Fraction` interface **plus** whatever is specified in the `Comparable` interface. More on this below! 

**Note: You do not need to modify the interface in any way. You just need to implement the interface, as descibed below and in the code for `FractionClass.java`.**

## The `FractionClass` implementation of the `Fraction` interface

You will implement the `Fraction.java` interface in a class called `FractionClass.java`. `FractionClass.java` will need to implement: (1) all the methods in the `Fraction` interface; (2) the `compareTo()` method from the `Comparable` interface, as shown above; (3) a constructor; and (4) a main method for testing your code.

### Methods in the `Fraction` interface
Most of these methods are perform arithmetic on fractions. You'll need to reduce the result of each operation to its lowest terms. I've given a few methods in the code that you are free to use. A few things to remember: 

* Do not change the method declarations (return type, method name, parameters) at all when you implement them. You'll note that many of them return a `Fraction`. That is okay! This is what polymorphism is all about.
* There should be no decimals at any time.
* If you have a denominator with a 0, return `null`. You don't need to throw an exception.

### The `compareTo()` method

The `Comparable` interface is an important built-in interface from `java.lang` which has one method:

```java
public interface Comparable<T> {
  int compareTo(T other);
}
```

We've talked a little bit about the `<T>` notation in class. Since the `Fraction` interface says `Comparable<Fraction>`, that means that when we write our implementation of `compareTo()`, we substitute in `Fraction` for `T `. Thus, when you write your `compareTo()` method in your `FractionClass.java` file, the method will look like this:

```java
int compareTo(Fraction other) {
  // blah blah blah
}
```

An implementation of `compareTo()` should return: 

* a positive number if the calling object is larger than the argument object
* a negative number if the calling object is smaller than the argument object
* 0 if the calling object and the argument object are equal

### The `FractionClass` constructor
Use the constructor to set the `numerator` and `denominator` instance variables.

### Unit testing in `main()`
The `main()` method of `FractionClass.java` runs some *unit tests*, which you can use to determine whether you are doing things correctly. When you run your code and uncomment what is in the main method, you should see the output that is indicated in the comments to the right of each method call in the main method.

You must provide **2 additional unit tests of the mathematical operations** using different fractions. Make your code look like the code provided for unit testing in `main()`. Specifically, in the comments, indicate what the expected output should be.

### Helper code
In the `FractionClass.java` file, I have provided some code for finding the least common multiple (`lcm`) and greatest common divisor (`gcd`), which you may find helpful.

---

## Pushing and verifying your submission

Once your code works to your satisfaction, push `FractionClass.java` to your personal master repo on the GitHub Classroom site, as you have done for your previous problem sets. Use the commit message "READY FOR GRADING" so we know you are done. 

---

## Important notes on grading

1. The `FractionClass.java` file **must be in the `src` directory**. You will lose 2 points if the file is in the wrong directory. The best way to make sure it is in the right place is to never ever move it in the first place.

2. Your code must compile. If a class does not compile, you will get a 0. If you are struggling and you aren't able to get in touch with me or the TAs, any TAs in the lab can help you compile your code. If it's 11:55pm on the day it's due and you don't want to take the late penalty, comment out the part of the code that is preventing compilation, and include an explanation of why you are commenting it out.

3. The TAs will review and run your code. Note that in addition to running your unit tests, they will try a few of their own. It's a good idea to do some error checking to avoid any surprises during grading.

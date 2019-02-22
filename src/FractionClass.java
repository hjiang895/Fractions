public class FractionClass implements Fraction {


  // Follow these instructions, which are outlined in
  // more detail in the problem set README.

  /* INSTANCE VARIABLES */
  // Create long type instance variables for the numerator and denominator
  private long num;
  private long denom;
  /* CONSTRUCTOR */
  // Implement the constructor to initialize the instance variables.
  public FractionClass(long num, long denom){
    this.num = num;
    this.denom = denom;

  }
  /* FRACTION INTERFACE METHODS */
  // Implement *all* the methods from the Fraction interface.
  // Do not change return type, spelling, parameters!
  public long getNumerator(){
    return num;
  }
  public long getDenominator(){
    return denom;

  }
  public Fraction plus(Fraction b){
    long bNum = b.getNumerator();
    long bDenom = b.getDenominator();
    if(bDenom == 0 || denom == 0){
      return null;
    }
    long commDenom = 0;
    long finalNum = 0;
    if(bDenom != denom) {
      commDenom = lcm(bDenom, denom);
      long bNum2 = bNum * (commDenom/bDenom);
      long num2 = num * (commDenom/denom);
      finalNum = bNum2 + num2;
    }
    else {
      commDenom = denom;
      finalNum = num + bNum;
    }

    FractionClass finalFrctn = new FractionClass(finalNum, commDenom);
    finalFrctn.reduce();
    return finalFrctn;


  }
  public Fraction subtract(Fraction b){
    long bNum = b.getNumerator();
    long bDenom = b.getDenominator();
    if(bDenom == 0 || denom == 0){
      return null;
    }
    long commDenom = 0;
    long finalNum = 0;
    if(bDenom != denom) {
      commDenom = lcm(bDenom, denom);
      long bNum2 = bNum * (commDenom/bDenom);
      long num2 = num * (commDenom/denom);
      finalNum = num2 - bNum2;
    }
    else {
      commDenom = denom;
      finalNum = num - bNum;
    }

    FractionClass finalFrctn = new FractionClass(finalNum, commDenom);
    finalFrctn.reduce();
    return finalFrctn;


  }
  public Fraction multiply(Fraction b){
    long bNum = b.getNumerator();
    long bDenom = b.getDenominator();
    if(bDenom == 0 || denom == 0){
      return null;
    }
    long finalNum = bNum * num;
    long finalDenom = bDenom * denom;
    FractionClass finalFrctn = new FractionClass(finalNum, finalDenom);
    finalFrctn.reduce();
    return finalFrctn;

  }
  public Fraction divide(Fraction b){
    long bNum = b.getNumerator();
    long bDenom = b.getDenominator();
    if(bDenom == 0 || denom == 0){
      return null;
    }
    long finalNum = num * bDenom;
    long finalDenom = denom * bNum;
    FractionClass finalFrctn = new FractionClass(finalNum, finalDenom);
    finalFrctn.reduce();
    return finalFrctn;


  }
  public Fraction powerOfN(int n) {
    if(denom == 0){
      return null;
    }
    long expNum = num;
    long expDenom = denom;
    for(int count = 1; count < n; count++){
      expNum = expNum * num;
      expDenom = expDenom * denom;
    }

	 // long expNum = Math.pow(num, n);
	  //long expDenom = Math.pow(denom, n);
	  FractionClass expFrac = new FractionClass(expNum, expDenom);
    expFrac.reduce();
    return expFrac;
}


  public boolean equals(Fraction other){
    //not sure how I could return null in the case of
    //a 0 denominator because the return type is a boolian
    long otherNum = other.getNumerator();
    long otherDenom = other.getDenominator();

    if(otherNum/otherDenom == num/denom){
      return true;
    }
    return false;
  }
  public String toString(){
    StringBuilder s = new StringBuilder();
    s.append(num);
    s.append("/");
    s.append(denom);
    return s.toString();

  }

  public void reduce(){
    long div = gcd(num,denom);
    num = num/div;
    denom = denom/div;

  }


  /* COMPARABLE INTERFACE METHOD (compareTo()) */
  // Implement compareTo() from the Comparable interface:
  // int compareTo(Fraction other)
  // Return positive number (e.g., 1) if the calling Fraction is bigger,
  // return negative number (e.g., -1) if the other Fraction is bigger,
  // return 0 if they are equal.

  public int compareTo(Fraction other){
    double thisNum1 = this.getNumerator();
    double thisNum2 = this.getDenominator();
    //not sure how I could return null in the case of a
    //a 0 denominator because the return type is an int
    double otherNum1 = other.getNumerator();
    double otherNum2 = other.getDenominator();
    double num1 = thisNum1/thisNum2;
    double num2 = otherNum1/otherNum2;
    if(num1 > num2){
      return 1;
    }
    else if (num1 < num2){
      return -1;
    }
    else {
      return 0;
    }


  }


  /* ARITHMETIC HELPER METHODS */
  // Helper method for least common multiple
  long lcm(long m, long n) {
    if (m < 0) m = -m;
    if (n < 0) n = -n;
    return m * (n / gcd(m, n));
  }

  // Helper method for greatest common divisor
  long gcd(long m, long n) {
    if (m < 0) m = -m;
    if (n < 0) n = -n;
    if (0 == n) return m;
    else return gcd(n, m % n);
  }


  /* MAIN METHOD */
  // The main() method does unit testing.
  // Here's an example for you to use, but
  // ** you must provide two more additional unit tests.**

  public static void main(String[] args) {
    // Uncomment the following code to run the unit test.


    Fraction r1 = new FractionClass(3, 9);
    Fraction r2 = new FractionClass(2, 10);
    Fraction r3 = r1.plus(r2);
    Fraction r4 = r1.subtract(r2);
    Fraction r5 = r1.multiply(r2);
    Fraction r6 = r1.divide(r2);
    Fraction r7 = r1.powerOfN(3);
    int r8 = r1.compareTo(r2);

    System.out.format("%s + %s = %s%n", r1, r2, r3);       // 8/15
    System.out.format("%s - %s = %s%n", r1, r2, r4);       // 2/15
    System.out.format("%s * %s = %s%n", r1, r2, r5);       // 1/15
    System.out.format("%s / %s = %s%n", r1, r2, r6);       // 5/3
    System.out.format("%s ^ 3 = %s%n", r1, r7);            // 27/729
    System.out.format("%s.compareTo(%s) = %s%n", r1, r2, r8);    // > 1

    Fraction f1 = new FractionClass(2, 5);
    Fraction f2 = new FractionClass(1, 2);
    Fraction f3 = f1.plus(f2);
    Fraction f4 = f1.subtract(f2);
    Fraction f5 = f1.multiply(f2);
    Fraction f6 = f1.divide(f2);
    Fraction f7 = f1.powerOfN(4);
    int f8 = f1.compareTo(f2);

    System.out.format("%s + %s = %s%n", f1, f2, f3);       // 9/10
    System.out.format("%s - %s = %s%n", f1, f2, f4);       // -1/10
    System.out.format("%s * %s = %s%n", f1, f2, f5);       // 1/5
    System.out.format("%s / %s = %s%n", f1, f2, f6);       // 4/5
    System.out.format("%s ^ 3 = %s%n", f1, f7);            // 16/625
    System.out.format("%s.compareTo(%s) = %s%n", f1, f2, f8);    // <-1

    Fraction n1 = new FractionClass(2, 8);
    Fraction n2 = new FractionClass(1, 5);
    Fraction n3 = r1.plus(r2);
    Fraction n4 = r1.subtract(r2);
    Fraction n5 = r1.multiply(r2);
    Fraction n6 = n1.divide(n2);
    Fraction n7 = n1.powerOfN(2);
    int n8 = n1.compareTo(n2);

    System.out.format("%s + %s = %s%n", n1, n2, n3);       // 9/20
    System.out.format("%s - %s = %s%n", n1, n2, n4);       // 1/20
    System.out.format("%s * %s = %s%n", n1, n2, n5);       // 1/20
    System.out.format("%s / %s = %s%n", n1, n2, n6);       // 5/4
    System.out.format("%s ^ 3 = %s%n", n1, n7);            // 1/16
    System.out.format("%s.compareTo(%s) = %s%n", n1, n2, n8);    // >1
  }


}

package java.numchallenge;

class NumUtil {
  private double num;
  
  NumUtil(double n) {
    num = n;
  }

  public String toString() {
    int tensDigit = (int) num / 10;
    double tensRemainder = num % 10;
    System.out.println("Tens: " + tensDigit);
    System.out.println("Tens remainder: " + tensRemainder);
    int onesDigit = (int) (tensRemainder / 1);
    double onesRemainder = tensRemainder % 1;
    System.out.println("Ones: "+  onesDigit);
    System.out.println("Ones remainder: "+  onesRemainder);
    int tenthDigit = (int) (onesRemainder * 10 / 1);
    System.out.println("Tenth: "+  tenthDigit);

    String numString = "Number: " + tensDigit + onesDigit + "." + tenthDigit;
    return numString;
  
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    double num = 12.3;
    NumUtil nUtil = new NumUtil(num);
    System.out.println(nUtil.toString());
  }
}

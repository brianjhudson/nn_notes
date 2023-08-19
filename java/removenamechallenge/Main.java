package java.removenamechallenge;

import java.util.ArrayList;
// class Thing {
//   Thing(String name, int age, double rbi) {
//     System.out.println("Gets invoked on object instantiation")
//   }
// }

// Thing t = new Thing("Brian", 43, 2.001);
// Thing t2 = new Thing("Nicole", 43, 2.001);


class Number {
  private double number;

  Number(double n) {
    number = n;
  }

  public double getNumber() {
    return number;
  }
  
  public double addOne() {
    double newNumber = number + 1;
    return newNumber;
  }

  public double increment() {
    return ++number;
  }

  public double add(double newNum) {
    // To not change number, use a new variable and return it
    // double num = number + newNum;
    // return num;

    // To change number, assign the sum to number before returning it
    number = number + newNum;
    return number;
  }

  public boolean isEven() {
    if (number % 2 == 0) {
      return true;
    }
    return false;
  }

  public String toString() {
    String numString = "Here is our number: " + number;
    return numString;
  }


  // public int[] getDigits() {
  //   int[] arrOfDigits = {1, 2, 3};
  //   return arrOfDigits;
  // }

}

class NumberArray {
  private int[] nums;

  NumberArray(int[] n) {
    nums = n;
  }

  public int[] getNums() {
    return nums;
  }
  
  public int getSum() {
    // practice looping through arrays
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
    }
    return sum;
  }
}

class InterviewQuestion {
  // WRite a method that takes the name "Brian" out of an array
  public String[] removeBrianFromNames(String[] names) {
    ArrayList<String> newNames = new ArrayList<String>();

    for (int i = 0; i < names.length; i++) {
      String name = names[i];
      if(name == "Brian") {
        System.out.println("Found it: " + name);
      } else {
        System.out.println("Not it: " + name);
        newNames.add(name);
      }
    }
    
    String[] removedNames = new String[newNames.size()];

    for (int i = 0; i < newNames.size(); i++) {
      String name = newNames.get(i);
      removedNames[i] = name;
    }
    return removedNames;
  }
}



class Main {
  public static void showNames(ArrayList<String> names) {
    for (String name : names) {
      System.out.println("Name: " + name);
    }
  }
  public static void main(String[] args) {
    // System.out.println("Hello world!");
    // Create (instantiate) an object of the Number class

    // type name = whatever it equals
    // double n = 12.3;
    // Number num = new Number(n);

    // Arrays 
    int[] intArray = {1,2,3,4};
    String[] strArray = {"Brian", "Nicole"};
    boolean[] boolArray = {true, false, true};

    NumberArray nArray = new NumberArray(intArray);

    // int sum = nArray.getSum();
    intArray[0] = 0;
    intArray[1] = 0;
    intArray[2] = 0;
    intArray[3] = 0;
    // intArray[4] = 1;
    // for (int i = 0; i < intArray.length; i++) {
    //   System.out.println(intArray[i]);
    // }

    // ArrayList<String> names = new ArrayList();
    // showNames(names);
    // names.add("Brian");
    // names.add("Nicole");
    // names.add("A new person");
    // showNames(names);
    // System.out.println("Size of names " + names.size());
    // names.remove(1);
    // showNames(names);
    // System.out.println("Size of names after remove 2: " + names.size());

    String[] namesArr = {"Brian", "Nicole"};
    InterviewQuestion iQuestion = new InterviewQuestion();
    String[] removed = iQuestion.removeBrianFromNames(namesArr);
    System.out.println("Removed length: " + removed.length);
    for (int i =0; i < removed.length; i++) {
      System.out.println("New name: " + removed[i]);
    }
    // for (String name : removed) {
    //   System.out.println("Name: " + name);
    // }
    // System.out.println("Sum: " + sum);
    
    // Implement the methods on the Number and NumberArray classes above. 
    // Instantiate the classes and test them here.
  }
}
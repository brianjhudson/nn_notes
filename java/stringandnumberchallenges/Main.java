package java.stringandnumberchallenges;

class Number {
  private double number;

  Number(double n) {
    number = n;
  }
  
  public double addOne() {
    return number;
  }

  public String toString() {
    return "";
  }

  public boolean isEven() {
    return false;
  }

  public int[] getDigits() {
    int[] arrOfDigits = {1, 2, 3};
    return arrOfDigits;
  }

}

class NumberArray {
  private int[] nums;

  NumberArray (int[] n) {
    nums = n;
  }
  
  public int getSum() {
    // practice looping through arrays
    return 0;
  }
}


class Text {
  private String text;

  Text (String t) {
    text = t;
  }

  public String getText() {
    return text;
  }

  public int getLength () {
    int length = text.length();
    return length;
  }

  public int getLengthManually() {
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
      count++;
    }
    return count;
  }

  // Write a method to count vowels in text
  public int countVowels() {
    int vowelCount = 0;

    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == 'a') {
        vowelCount++;
      } else if (text.charAt(i) == 'e') {
        vowelCount++;
      }
    } 

    return vowelCount;
  }

  public String reverseString() {
    String reversedText = "";

    // Loop backwards through the string

    // for(int i =0; i < text.length(); i++) {
      
    // }
    for(int i = text.length() - 1; i >= 0; i--) {
      // System.out.println("Index: " + i + ", Character: " + text.charAt(i));
      reversedText += text.charAt(i);
      
    }
    return reversedText;
    
  }

  public boolean isPalindrome() {
    // Loop through string backwards and reverse string
    // If statement to compare string and reversed string

    // Initialize an empty string
    String reversed = "";
    
    for(int i = text.length() - 1; i >= 0; i--) {
      // Add to the string to create reversed string
      reversed += text.charAt(i);
      
    }

    // Compare reversed to original
    if (reversed.equals(text)) {
      return true;
    }
    return false;
  }

  public boolean isPalindromeWithComposition() {
    String reversed = this.reverseString();
    if (reversed.equals(text)) {
      return true;
    }
    return false;
  }

  public boolean isPalindrome2() {
    if (text.length() == 1) {
      return false;
    }
    for(int i = 0, j = text.length() - 1; i < j; i++, j--) {
      System.out.println(i + ", " + j);
      // if characters don't match, return false
      if (text.charAt(i) != text.charAt(j)) {
        return false;
      }
    }
    return true;
  }

}


class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    // 1. Create a new instance of the Text class.
    Text t = new Text("?Hew long am I?");
    // 2. Create a method on the Text class that returns length of a given String.
    String text = t.getText();
    int length = t.getLength();
    int lengthManual = t.getLengthManually();
    System.out.println("Text: " + text);
    System.out.println("Length: " + length);
    System.out.println("Length Manually: " + lengthManual);
    

    // 3. Create a method that returns the number of vowels in a string.
    int vowelCount = t.countVowels();
    System.out.println("Vowel count: " + vowelCount);
    
    
    // 4. Write a method that reverses a given string.
    String reversed = t.reverseString();
    System.out.println("Reversed: " + reversed);

    // 5. Write a method that returns true if the string is a palindrome and false if it is not.
    boolean palindromeT1 = t.isPalindrome(); // False
    System.out.println("Is t1 a palindrome? " + palindromeT1);

    Text t2 = new Text("dad");
    boolean palindromeT2 = t2.isPalindrome(); // True
    System.out.println("Is t2 a palindrome? " + palindromeT2);

    System.out.println(t2.isPalindrome2());
  // t.isPalindrome() -> false
  // "dad".isPalindrome() -> true

  }
}

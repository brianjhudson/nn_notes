package java.wordcount;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/* 
  Challenge for Interview
  Create a class with a method that accepts a string of text and         return the longest word.

  Then invoke that class's method in the main method of the Main         class
*/

class TextUtil {
  // Create method here
  public int getWordCount (String text) {

    /*
      Option 1:
      Loop through string
      Count spaces
    */

    /*
      Option 2:
      Split the string on the spaces
      Use the length property of the array to get word count
    */

    // "hello world" -> ["hello", "world"]
    // const words = text.split(" ");
    String[] words = text.split(" ");
    // Declare a variable to hold the number of words
    // int wordCount = words.length;
    // TODO: Use a manual loop to count the number of elements
    int wordCount = 0;

    // for(int i = 0; i < words.length; i++) {
    //   // wordCount = wordCount + 1;
    //   // wordCount += 1;
    //   wordCount++;
    // }

    for (String word : words) {
      wordCount++;
    }

    int[] nums = {1, 2, 3};

    for (int num : nums) {
      System.out.println("Num" + num);
    }
    
    return wordCount;
  }
 
  // (accessLevel) returnType methodName (parameters) {
  
  // }

  
}

class NumUtil {
}

class Main {
  public static void main(String[] args) {
    TextUtil tu = new TextUtil();
    int wordCount = tu.getWordCount("Hello world there");
    System.out.println("Word count: " + wordCount);
    // Part 1: create a method in TextUtil to find the longest word in a     string
    // Then invoke the method here.

    
    // NumUtil nu = new NumUtil();
  }

}


// Interview
// 1. Monday Java review -- example and review
// 2. Tuesday Java review
// 3. After Tuesday, return to JavaScript and pick up with data structures, loops, 
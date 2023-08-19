package java.stringutils;

class Text {

  public int getLength (String input) {
    return input.length();
  }
  public String reverse(String input) {
    String reversed = "";
    for (int i = input.length() - 1; i >= 0; i-- ) {
      reversed += input.charAt(i);
    }
    return reversed;
  }
  public boolean isAnagram(String input) {
    String lowered = input.toLowerCase();
    for (int i = 0, j = lowered.length() - 1; i < j; i++, j--) {
      if (lowered.charAt(i) != lowered.charAt(j)) {
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
    
    // 2. Create a method on the Text class that returns length of the string

    // 3. Test that method by calling it on your instance.


    // 4. Write a method that reverse the string. 


    // 5. Test your method by calling it on your instance.

    // 6. Write a method that returns true if the input string is an anagram and false if it is not.


    // 7. Test your method by calling it on your instance.
    Text t = new Text();
    System.out.println(t.isAnagram("Dad"));
  }
}
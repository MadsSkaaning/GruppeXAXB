import java.util.Scanner;

public class Main {


public static void main(String args[]) {
      
        //create Scanner instance to get input from User
        Scanner scanner = new Scanner(System.in);
      
	  // Det her er fra nu af den nye gruppe chat, ja tak! Ses vi forresten alle sammen på lørdag???
        System.err.println("Please enter first number to add : ");
        int number = scanner.nextInt();
      
        System.out.println("Enter second number to add :");
        int num = scanner.nextInt();
      
        //adding two numbers in Java by calling method
       int result = add(number, num);
	   
	   //Hej bøsser <3
      
       System.out.printf(" Addition of numbers %d and %d is %d %n", number, num, result);
    }
  
    public static int add(int number, int num){
        return number + num;
    }
}
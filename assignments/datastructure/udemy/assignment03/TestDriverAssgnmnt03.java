/*
 * 
 *  Write a class Employee, which represents an employee in a company. The employee has a employeeNumber (9 digit number), firstName, lastName and emailId as member variables.
 *  Create a few employee objects and store them in an array. Write the insertion sort algorithm,
 *  which takes an array of employee and sorts them in order of their employee number.
 *  
 *  Write an algorithm which checks if there are duplicate characters in a string. 
 *  The method signature would look something like public boolean hasDuplicateChars(String s) . 
 *  If we pass "anaconda" the method should return true (repeated char 'a'). If we pass 'great', the method should return false, because there are no duplicate characters in the string.
 *  What is the time complexity of this algorithm? If we know that the string contains ONLY ASCII characters, can we improve the algorithm?
 *  
 *  Write an algorithm that takes two strings and returns a boolean value indicating if the strings are anagrams.
 *   If you don't know what an anagram is, search for the word (not the algorithm) online. What is the time complexity of this algorithm?
 * 
 */

package assignments.datastructure.udemy.assignment03;

import java.util.Scanner;

public class TestDriverAssgnmnt03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboardReader = new Scanner(System.in);

// test for duplicate
//		System.out.println("Enter a string: ");
//		String inputString = keyboardReader.next();
//		String dummy = keyboardReader.nextLine();
//		//System.out.println(new duplicateCharDetector().checkDuplicateCharsByRecursion(inputString));
//		System.out.println(new duplicateCharDetector().hasDuplicateChars(inputString));
//		
		
// test for AnagramChecker
		System.out.println("Enter first string: ");
		String firstSring = keyboardReader.next();
		String dummy0 = keyboardReader.nextLine();
		
		
		System.out.println("Enter second string: ");
		String secondSring = keyboardReader.next();
		String dummy1 = keyboardReader.nextLine();
		
		System.out.println(new AnagramChecker().charSetsCheck(firstSring, secondSring));
		
		
		keyboardReader.close();
	}
}
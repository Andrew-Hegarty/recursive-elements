import java.lang.reflect.Array;
import java.util.*;

public class Recursion_Stringbuilding1 {
	
	public static int sum(int n) { 
		//Pre: n >= 0 
		//Post: Returns sum of first n numbers recursively
		
		if (n == 1) {
			return 1;
		} else {
			return n + sum(n-1);
		}
		
	}
	
	public static int sum2(int n) { 
		//Pre: n >- 0 
		//Post: Returns sum of first n positive integers iteratively
		
		int sum = 0;
		
		for (int i = 0; i <= n; i++) {
			sum += i;
		}
		
		return sum;
		
	}
	
	public static int sumOfSquares(int n) { 
		//Pre n >= 0 
		//Post: Return sum of the squares of the first n positive integers
		
		if (n <= 1) {
			return 1; // Base Case
		} else {
			return n * n + sumOfSquares(n-1);
		}
		
	}
	
	public static int factorial(int n) {
		//Pre: n >= 0 and n must be an integer
		//Post: Returns n!
		
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
		
	}
	
	//Running Time = O(2^n) --> Exponential Reunning Time (Bad)
	public static int fibonacci(int n) { //1, 1, 2, 3, 5, 8, 13
		//Pre: n must be a positive integer
		//Post:Return the nth fibonacci number
		
		if (n <= 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		
	}
	
	public static boolean isPalindrome(String s) {
		
		if (s.length() <= 1) {
			return true;
		} else if (s.charAt(0) != s.charAt(s.length() - 1)) {
			return false;
		} else {
			return isPalindrome(s.substring(1, s.length() - 1));
		}
		
	}
	
	public static boolean isPalindrome2(String s, int i, int j) {
		
		if (i > j) {
			return true;
		} else if (s.charAt(i) != s.charAt(j)) {
			return false;
		} else {
			return isPalindrome2(s, ++i, --j);
		}
		
	}
	
	public static boolean isPalindrome3(String s, int i, int j) {
		
		if (i >= j) {
			return true;
		} else if (s.substring(i, i + 1).equals(s.substring(j - 1, j))) {
			return false;
		} else {
			return isPalindrome3(s, ++i, --j);
		}
		
	}
	
	//Running Time: O(lognbase2)
	public static int binarySearch(int[] array, int i, int j, int key) {
		//Pre: array must be sort --> increasing
		//Post:
		
		int mid = (i + j) / 2;
		
		if (i >= j) {
			return -1;
		} else if (array[mid] == key) {
			return mid;
		} else if (key > array[mid]) {
			return binarySearch(array, mid + 1, j, key);
		} else {
			return binarySearch(array, i, mid, key);
		}
		
	}
	
	public static void tokenize(String t) {
		
		StringTokenizer tokenizer = new StringTokenizer(t, "\"\\,;'! ");
		
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			System.out.println(token);
		}
		
	}
	
	public static void reverseArray(int[] array, int i, int j) {
		
		if (i < j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			reverseArray(array, ++i, ++j);
		}
		
	}
	
	public static void stackWords() {
		
		String word = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What is the word?");
		word = scan.next(); //Assumes no spaces
		
		if (!word.equals(".")) {
			stackWords();
		}
		
		System.out.println(word);
		
	}
	
	public static int fibRecLinear(int a, int b, int n) {
		
		if (n == 1) {
			return a;
		} else if (n == 2) {
			return b;
		} else {
			return fibRecLinear(b, a + b, n - 1);
		}
		
	}
	
	public static void bubbleSort(int[] array) {
		
		for (int i = 0; i < array.length - 1; i++) { //Control Passes
			
			for (int j = 0; j < array.length - 1 - i; j++) { // Control Comparisons
				
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				
			}
			
		}
		
	}
	
	//Dynamic Programming Practices
	//SelectionSort, BubbleSort O(n^2)
	//QuickSort, MergeSort O(nlog2n)
	public static void main(String[] args) {
		
		System.out.println(sum(100));
		System.out.println(sum2(100));
		System.out.println(sum2(5));
		System.out.println(sumOfSquares(5));
		System.out.println(factorial(5));
		System.out.println(fibonacci(6));
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome2("redbull",2 ,5));
		
		int[] array = {10, 20, 30, 40};
		System.out.println(binarySearch(array, 0, array.length, 40));
		
		String T = "I ha,ve no!t yet beg\"un to fi!ght";
		tokenize(T);
		String T2 = "I have;not, yet, begun to fight \\just yet\\";
		tokenize(T2);
		
		for (int i = 65; i < 91; i++) {
			//System.out.println(i + "\t" + (char)i); //Prints ASCII code (Alphabet)
		}
		
		int[] a = {80, 70, 60, 50, 40};
		//reverseArray(a, 0, a.length - 1);
		
		System.out.println(fibRecLinear(1, 1, 3));
		
	}
	
}

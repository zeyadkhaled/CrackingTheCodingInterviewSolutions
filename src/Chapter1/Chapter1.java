package Chapter1;
import java.util.Arrays;
import java.util.HashSet;

public class Chapter1 {
	
	/**
	 * #1.1# Solution (1) using BitVector
	 */
	public static boolean isUnique( String word ) {
		int checker = 0;
		for ( int i = 0 ; i < word.length(); i++) { 
			int letterVal = word.charAt(i) - 'a';
			if ( (checker & (1 << letterVal)) > 0) {
				return false;
			}
			 checker |= ( 1 << letterVal);
		}
		return true;
	}
	
	/**
	 * #1.2# Solution (1) using Array Sorting
	 */
	public static boolean isPermutation( String word1, String word2 ) {
		char[] word1Char = word1.toCharArray();
		Arrays.sort( word1Char);
		word1 = new String(word1Char);
		
		char[] word2Char = word2.toCharArray();
		Arrays.sort( word2Char);
		word2 = new String(word2Char);
		
		return word1.equals(word2);
	}
	
	/**
	 * #1.4# Solution (1) using Hash Tables
	 */
	public static boolean isPalindorme(String word) {
		HashSet<Character> set = new HashSet<>();
		
		// Go through all the letters in the string
		for ( int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			// Process letter only if part of the alphabet
			if ( Character.isAlphabetic(letter) ) {
				// If letter has been added once, remove it
				if ( set.contains(letter))
					set.remove(letter);
				else
					// else put it in the set
					set.add(letter);
			}
		}
		
		// If after processing the set its size is 0 or 1 it means the word is a palindorme
		if (set.size() <= 1)
			return true;
		
		return false;
	}
	
	/**
	 * #1.4# Solution (2) using Bit Vectors
	 */
	public static boolean isPalindormeTwo( String word) {
		int checker = 0;
		// Go through all the letters in the string
		for ( int i = 0; i < word.length(); i++) {
			
			char letter = word.charAt(i);
			letter = Character.toLowerCase(letter);
			
			// Process letter only if part of the alphabet
			if ( Character.isAlphabetic(letter)) {
				
				int valOfChar = letter - 'a';
				int mask = ( 1 << valOfChar);
				// if checker and mask evaluate to 0 it means bit is unassigned
				if ( (checker & mask) == 0) 
					checker |= mask; //Assign the bit by ORing checker and mask
				else 
					checker &= ~mask; //Unassign the bit by ANDing the negation of the mask
			}
		}
		
		// if checker has all bits are zero or only one is 1 then its a Palindorme
		if ( checker == 0 || ( (checker & (checker - 1)) == 0 ))
			return true;

		return false;
	}
	
	/**
	 *  #1.5# Solution 
	 */
	public static boolean isOneAway(String word1, String word2) {
		// If words length differ by more than one, return false
		if ( Math.abs(word1.length() - word2.length()) > 1)
			return false;
		
		HashSet<Character> set = new HashSet<>();
		// Go through first word and fill the set with it's letters
		for ( int i = 0; i < word1.length(); i++) {
			char letter = word1.charAt(i);
			set.add(letter);
		}
		
		// Go through other word removing all letters that match from first word or add it if it doesn't exist in other word
		for ( int i = 0; i < word2.length(); i++) {
			char letter = word2.charAt(i);
			if ( set.contains(letter)) 
				set.remove(letter);
			else 
				set.add(letter);
		}
		
		// If at the end set size isn't 0,1, or 2 it means the words are more than one change away
		if (set.size() <= 2)
			return true;
		return false;
	}
	
	/*
	 * #1.6# Solution
	 */
	public static String compressString(String word) {
		StringBuilder compressed = new StringBuilder();
		int counter = 1;
		char prevLetter = word.charAt(0); //Initialize prevLetter to the first char in the word
		
		for ( int i = 1 ; i < word.length(); i++) {
			char currLetter = word.charAt(i);
			
			if ( prevLetter == currLetter) { // Check if current letter us similar to previous letter
				counter++;
				prevLetter = currLetter;
			} else {
				compressed.append(prevLetter); // If not, append letter and counter to string builder
				compressed.append(counter);
				counter = 1;
				prevLetter = currLetter;
			}
			
		}
		//Loop exits before adding last letter
		compressed.append(prevLetter);
		compressed.append(counter);

		return compressed.length() < word.length() ? compressed.toString() : word;
	}
	/*
	 * #1.7# Solution
	 */
	public static void rotateMatrix( int[][] matrix, int n) {
		for ( int layer = 0; layer < (n / 2); layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for ( int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = matrix[first][i];
				// left to top
				matrix[first][i] = matrix[last - offset][first];
				//bottom to left
				matrix[last - offset][first] = matrix[last][last - offset];
				//right to bottom
				matrix[last][last - offset] = matrix[i][last];
				//top to right
				matrix[i][last] = top;
			}
		}
	}
	/*
	 * #1.8# Solution
	 */
	public static void nullifyMatrix( int[][] matrix, int m, int n) {
		boolean rowZero = false;
		boolean colZero = false;
		
		//Check if first row has any zeros
		for ( int col = 0; col < n; col++) {
			if ( matrix[0][col] == 0)
				rowZero = true;
			break;	
		}
		//check if first col has any zeros
		for ( int row = 0; row < m; row++) {
			if ( matrix[row][0] == 0)
				colZero = true;
			break;	
		}
		//Go over the whole array if zero is found set the 0 respectively in first row and col
		for ( int row = 0; row < m; row++) {
			for ( int col = 0; col < n; col++) {
				if ( matrix[row][col] == 0) {
					matrix[0][col] = 0; //set zero in first row
					matrix[row][0] = 0; //set zero in first col
				}
			}
		}
		//Go over first row, nullifying cols
		for ( int col = 0; col < n; col++) {
			if ( matrix[0][col] == 0) {
				for (int j = 0; j < m; j++) {
					matrix[j][col] = 0;
				}
			}
				
		}
		//Go over first col, nullifying rows
		for ( int row = 0; row < m; row++) {
			if ( matrix[row][0] == 0) {
				for (int j = 0; j < n; j++) {
					matrix[row][j] = 0;
				}
			}

		}
		
		//if first row has zero, then nullify row
		if ( rowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		
		//if first col has zero, then nullify col
		if ( rowZero) {
			for (int j = 0; j < m; j++) {
				matrix[j][0] = 0;
			}
		}			
	}
	
	/**
	 * #1.9# Solution
	 */
	public static boolean isRotation(String s1, String s2) {
		String s1s1 = s1 + s1;
		for ( int i = 0; i < s1s1.length() - s2.length(); i ++) {
			if ( s1s1.substring(i, i + s2.length() ).equals(s2)) {
				return true;
			}
		}
		return false;
	}
    
    public static void main( String[] args) {
        //Testing 1.1
    	System.out.println( "1.1 Solutions: ");
    	System.out.println("(Bit Vector Solution) Does \"abcdea\" has unqiue charactes? " + isUnique("abcdea"));
    	System.out.println();
    	
    	//Testing 1.2
    	System.out.println( "1.2 Solutions: ");
    	System.out.println("(Arrays Sorting) Is \"ball\" a permutation of \"labl\"? " + isPermutation("ball", "labl"));
    	System.out.println();

    	//Testing 1.4
    	System.out.println( "1.4 Solutions: ");
    	System.out.println("(Hash Set Solution) Is \"taco cat\" a palindorme? " + isPalindorme("taco cat"));
    	System.out.println("(Bit Vector) Is \"ho  of\" a palindorme? " + isPalindormeTwo("ho  of"));
    	System.out.println();
    	
    	//Testing 1.5
    	System.out.println( "1.5 Solutions: ");
    	System.out.println("(Hash Set Solution) Is \"pale\" and \"bale\" one letter away? " + isOneAway("pale" , "bale"));
    	System.out.println();
    	
    	//Testing 1.6
    	System.out.println( "1.6 Solutions: ");
    	System.out.println("(StringBuilder Solution) Compress the string \" aabcccccaaa \" : " + compressString("aabcccccaaa"));
    	System.out.println();
    	
    	//Testing 1.7
    	System.out.println( "1.7 Solutions: ");
    	System.out.println("(MultiDimension Arrays) Rotate this array 90 degress");
    	int n = 3;
    	int[][] matrix = new int[n][n];
    	for ( int i = 0, x = 1; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			matrix[i][j] = x;
        		x++;
    		}
    	}
    	for ( int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			System.out.print(matrix[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println("ROTATED");
    	rotateMatrix(matrix, n);
    	for ( int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			System.out.print(matrix[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	
    	//Testing 1.8
    	System.out.println( "1.8 Solutions: ");
    	System.out.println("(MultiDimension Arrays) Nullify this array");
    	int row = 3;
    	int col = 3;
    	int[][] matrix2 = new int[row][col];
    	for ( int i = 0, x = 1; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			matrix2[i][j] = x;
        		x++;
    		}
    	}
    	matrix2[row/2][col-1] = 0;
    	for ( int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			System.out.print(matrix2[i][j] + " ");
    		}
    		System.out.println();
    	}
    	nullifyMatrix(matrix2, row, col);
    	System.out.println( "Nullify where zero was found");
    	for ( int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			System.out.print(matrix2[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	
    	//Testing 1.9
    	System.out.println( "1.9 Solutions: ");
    	System.out.println("(String Substring) is \" erbottlewat \" a rotation of \" waterbottle \" ? " + isRotation("waterbottle", "erbottlewat"));
    }
}

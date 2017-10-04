package assignments.datastructure.udemy.assignment03;

import java.util.Arrays;

public class AnagramChecker {
	
	public boolean myRecursiveCheck(String word1, String word2){
		
		if( (word1.length() != word2.length()) ){
			return false;
		}
		
		//search every char of word1 in word 2
		
		
		
		char[] word1AsArray = new char[word1.length()];
		char[] word2AsArray = new char[word2.length()];
		
		
		
		for(int i=0; i<word1AsArray.length; i++){
			word1AsArray[i] = word1.charAt(i);
			word2AsArray[i] = word2.charAt(i);
		}
		
		
		
		char currentCahr = word1AsArray[0];
		
		//
		int insertIndex = new AnagramChecker().searchThisChar(currentCahr, word2AsArray);
		
		if( -1 != insertIndex){
			
			if(word1.length() ==1 && word2.length() == 1){
				return true;
			}
			
			word2AsArray[insertIndex] = '\n';
			word1AsArray[0] = '\n';
			
			StringBuffer newString1 = new StringBuffer(0);
			StringBuffer newString2 = new StringBuffer(0);
			
			//construct two new string
			for(int j=0; j<word1AsArray.length; j++){
				if(word1AsArray[j] != '\n'){
					newString1.append(word1AsArray[j]);
				}
			}
			
			
			for(int j=0; j<word2AsArray.length; j++){
				if(word2AsArray[j] != '\n'){
					newString2.append(word2AsArray[j]);
				}
			}

			
			//debug
			System.out.println("word1 length: "+ newString1.length()+"\nword2 length: "+ newString2.length());
			
			return myRecursiveCheck(newString1.toString(), newString2.toString());
			
			
		}else{
			return false;
		}
			
	}
	
	
	public int searchThisChar(char key, char[] charArray){
		for(int i=0 ; i< charArray.length; i++)
			if( key == charArray[i]){
				return i;
		}
		return -1;
	}
	
	
	
	public boolean charSetsCheck(String a, String b){
		
		if(a.length() != b.length() || a.equals(b)){
			return false;
		}
		
		int[] charMatrix1 = new int[256];
		int[] charMatrix2 = new int[256];
		
		
		
		for(int i=0; i<a.length();i++){
			int charId1= a.charAt(i);
			charMatrix1[charId1]++;
			int charId2= b.charAt(i);
			charMatrix2[charId2]++;
		}
		
		
		if(Arrays.equals(charMatrix1, charMatrix2)){
			return true;
		}else{
			return false;
		}
	}
	
	
}

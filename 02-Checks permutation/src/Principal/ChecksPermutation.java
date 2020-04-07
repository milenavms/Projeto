package Principal;

public class ChecksPermutation {
	public static void main(String args[]) {

        System.out.println(checkPermutation("you", "yuo"));
        System.out.println(checkPermutation("probably", "porbalby"));
        System.out.println(checkPermutation("despite", "desptie"));
        System.out.println(checkPermutation("moon", "nmoo"));
        System.out.println(checkPermutation("misspellings", "mpeissngslli"));
        
    }
    
    /*
     * Check permutation in words
     */
    static boolean checkPermutation(String wordA, String wordB) {

        //Permutation occurs only if:
    	//The words are the same size
        if(wordA.length() == wordB.length()) {  
        	//Words with first letter equal
            if(wordA.charAt(0) == wordB.charAt(0)) {  
            	//If the two words contain the same letters
            	if(checkEqualLetter(wordA,wordB)) {        		
            		if(wordA.length() < 4){
                    	return true;
                    }else if(checkPercentage(wordA,wordB)) { //2/3 or 66.666% change then has permutation
                    	return true;
                    }else {
                    	return false; 
                    }          
            		
            	}else {
            		return false;
            	}
            }else {
            	return false;
            }
        }
        
        return false;     
  }

    /*
     * Checks whether the two words contain the same letters
     */
    static boolean checkEqualLetter(String wordA, String wordB) {
    	
    	char[] wordAux = wordA.toCharArray();         
    	int count; 
    	String letter ="";
     
        for(int i = 0; i < wordB.length(); i++) {    
            count = 0;                                
            for(int j = 0; j < wordAux.length; j++) {  
                if(wordB.charAt(i) == wordAux[j]) {
                    wordAux[j] = ' ';  
                    count++; 
                    break;
                }
            }
            //Counter ("letter") checked the letter of ("wordB") that is not in ("wordA")
            if(count == 0) { 
            	letter +=  String.valueOf(wordB.charAt(i)); 
            }
        }
             
        if(letter.length() == 0) { 
            return true;
        }else {
        	return false;	
        }
    
        	
}
    /*
     * Verification of the percentage of change of letters
     */
    static boolean checkPercentage(String wordA, String wordB) {
    	float countEquals = 0;
    	//Check the number of times the letter has been moved
        for(int i = 0; i < wordA.length(); i++) { 
            if(wordA.charAt(i) != wordB.charAt(i)) {
                countEquals++;
            }
        }
          
       //calculation of the percentage variation of letters 
        float percent = (100*countEquals)/wordA.length();           

        //2/3 or 66.666% change then has permutation
        if(percent < 66.6666) { 
            return true;
        }else{ 
            return false;
        }
    	
    }
}

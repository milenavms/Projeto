package Principal;

public class Principal {
	public static void main(String args[]) {
		
		System.out.println(checkWordsTypos("pale", "ple"));
		System.out.println(checkWordsTypos("pales", "pale"));
		System.out.println(checkWordsTypos("pale", "bale"));
		System.out.println(checkWordsTypos("pale", "bake"));

    }
	
	static boolean checkWordsTypos(String wordA, String wordB) {

        if(wordB.length() == wordA.length()) {
        	
        	if(oneReplace(wordA, wordB)) {
        		return true;
        	}else {
        		return false;
        	}
        	
        }else {
            if(wordB.length() > wordA.length()) { 
            	
            	if(insertCheck(wordA,  wordB)) {
            		return true;
            	}else {
            		return false;
            	}
            	
                 
            }else {
            	
            	if(deleteCheck(wordA ,  wordB)) {
            		return true;
            	}else {
            		return false;
            	}
               
                
            }
        }
    }
	
	static boolean oneReplace(String wordA, String wordB) {
	
            int replace = 0;
            //Check quantity of modifications (replace)
            for(int i = 0; i < wordB.length(); i++) {
                if(wordB.charAt(i) != wordA.charAt(i)) { 
                    replace++;
                }
            }
            
            //a typo if:
            //replace number equal to one
            if(replace == 1) {
                return true;
            }
            return false;
            
	}
	
	static boolean insertCheck(String wordA, String wordB) {
		
		if(wordB.length() - wordA.length() == 1) { 
            char[] wordAux = wordA.toCharArray();  
            int count;  
            String letra = ""; 
            for(int i = 0; i < wordB.length(); i++) { 
                count = 0;
                for(int j = 0; j < wordAux.length; j++) {
                    if(wordB.charAt(i) == wordAux[j]) {
                        wordAux[j] = ' ';  
                        count++;  
                        break;
                    }
                }
                if(count == 0) { 
                    letra +=  String.valueOf(wordB.charAt(i)); 
                }
            }
            
            //a typo if:
            //insertion number equal to one
             if(letra.length() == 1) 
                 return true;
             else
            	 return false; 
        }
        return false; 
		
	}
	
	
	static boolean deleteCheck(String wordA, String wordB) {
		if(wordA.length() - wordB.length() == 1  ) { 
            char[] wordAux = wordB.toCharArray();  
            int count;  
            String letra = ""; 

            for(int i = 0; i < wordA.length(); i++) { 
                count = 0;
                for(int j = 0; j < wordAux.length; j++) {
                    if(wordA.charAt(i) == wordAux[j]) {
                        wordAux[j] = ' '; 
                        count++;  
                        break;
                    }
                }
                if(count == 0) { 
                    letra +=  String.valueOf(wordA.charAt(i)); 
                }
            }
            
            //a typo if:
            //exclusion number equal to one
            if(letra.length() == 1) 
            	return true;

            return false; 
        }
        return false; 
	}
	
}

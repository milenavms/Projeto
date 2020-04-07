package Principal;

public class ReplacingCharacters {

	public static void main(String[] args) {
		String palavra2 = "\"User is not allowed   \", 19";
        String newWord = addCodeInSpaces(palavra2);
        System.out.println(newWord);

	}
	
	static String addCodeInSpaces(String word) {

        //Saves the number representing the amount of characters (19 = 91)
        String sizeInvertido = "";
        for(int i = word.length()-1; i >= 0; i--) {
            if(word.charAt(i) != ',') {           	
                sizeInvertido += word.charAt(i);
            } else {
                break;
            }
        }
       
        //Reverses the number of total characters
        String sizeString = new StringBuilder(sizeInvertido.trim()).reverse().toString(); 
       
        int size = Integer.parseInt(sizeString);

        String ultimoCaracter = "\"";

        String newWord = "";
        
        //increments the size by 1 because it starts with quotation marks
        for(int i = 0; i < size+1; i++) {
            if (word.charAt(i) == 160 || word.charAt(i) == 32) {
                newWord += "&32";
            } else {
                newWord += word.charAt(i);
            }
        }

        return newWord+ultimoCaracter;
    }

}

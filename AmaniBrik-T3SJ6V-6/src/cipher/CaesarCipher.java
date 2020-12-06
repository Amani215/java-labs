package cipher;

public class CaesarCipher{	
	public String text;
	
	public CaesarCipher(String input, char offSet){
		text=caesarCode(input,offSet);
	}
	
	private String caesarCode(String input, char offSet) {
		input=input.toUpperCase();
		String res = new String("");
		
		if((offSet<(90-26))||(offSet>90)) 
			return input;
		
		for(int i=0; i<input.length();i++) {
			int newChar = input.charAt(i)+(offSet-'A');
			if(newChar>90) {
				newChar = newChar-26;
			}
			res= res+ ((char) (newChar));
		}
		
		return res;
	}
}

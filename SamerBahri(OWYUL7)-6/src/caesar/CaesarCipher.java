package caesar;

public class CaesarCipher {
	private String caesarCode(String input,char offSet) {
		input=input.toUpperCase();
		String result ="";
		
		for(int i=0;i<input.length();i++) {
			char c = (char) ((input.charAt(i)-'A'+offSet-'A')%26);
			c= (char) (c+'A');
			result+=c;
		}
		return result;
	}
	
	public String returnCode(String input,char offSet) {
		return caesarCode(input,offSet);
	}
}

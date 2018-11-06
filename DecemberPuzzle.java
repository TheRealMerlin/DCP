import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class DecemberPuzzle {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("decemberEND.dat"));
		String plain = in.nextLine();
		int[] vkey = makeVKey("stupendeous");
		String vEnc = "stupendeous - ";
		for(int i = 0; i < plain.length(); i++) {
			char c = plain.charAt(i);
			char newC = (char)(c + vkey[i%vkey.length]);
			if(c >= 97 && c <= 122) {
				while(newC > 122) {
					newC -= 26;
				}
				vEnc += newC;
			}else if(c >= 65 && c <= 90) {
				while(newC > 90) {
					newC -= 26;
				}
				vEnc += newC;
			}else {
				vEnc += c;
			}
		}
		out.println(vEnc);
		String hexEnc = "";
		for(int i = 0; i < vEnc.length(); i++) {
			vEnc += Integer.toString(Integer.parseInt(vEnc.substring(i, i+1), 16));
		}
		out.println(hexEnc);
		int col = 13;
		int row = 9;
	}
	
	public static int[] makeVKey(String str) {
		int[] arr = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - 'a';
		}
		return arr;
	}
}

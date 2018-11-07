import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class DecemberPuzzle {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("decemberEND.dat"));
		String plain = in.nextLine();
		int[] vkey = makeVKey("celebration");
		String vEnc = "celebration - ";
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
		ArrayList<Integer> vEncNum = new ArrayList<Integer>();
		for(int i = 0; i < vEnc.length(); i++) {
			vEncNum.add((int)vEnc.charAt(i));
		}
		int[][] mKey = {
				{'h', 'a', 'p', 'p', 'y'}, 
				{'h', 'o', 'l', 'l', 'y'},
				{'h', 'o', 'l', 'i', 'd'},
				{'a', 'y', 'c', 'a', 'r'},
				{'o', 'l', 'e', 'r', 's'}};
		int[][] mUnc = new int[7][5];
		int[][] mEnc = new int[7][5];
		int vEncNumPos = 0;
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 5; j++) {
				mUnc[i][j] = vEncNum.get(vEncNumPos);
				vEncNumPos++;
			}
		}
		for(int x = 0; x < 7; x++) {
			for(int i = 0; i < 5; i++) {
				int sum = 0;
				for(int j = 0; j < 5; j++) {
					sum += mUnc[x][j] * mKey[j][i];
				}
				mEnc[x][i] = sum;
			}
		}
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 5; j++) {
				mEnc[i][j] = mEnc[i][j] % 256;
			}
		}
		for(int[] a : mEnc) {
			for(int b : a) {
				out.print(Integer.toString(b, 16) + " ");
			}
			out.println();
		}
	}
	
	public static int[] makeVKey(String str) {
		int[] arr = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - 'a';
		}
		return arr;
	}
}

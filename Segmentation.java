import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Segmentation {
	
	Set<String> dic = new HashSet<>();
	
	int quality(String s) {
		if (this.dic.contains(s)) return 1;
		else return -1;
	}
	
	int segment(String s) {
		int[][] tab = new int[s.length()][s.length()+1];
		tab[0][0] = 0;
		int max = 0 ;
		
	
		for (int i = 0;i <s.length() ;i++)
			for (int j = i+1;j<=s.length();j++) {
				int val = this.quality(s.substring(i, j));
				tab[i][j] = val;
				if (i-1 >=0) {
				val = val + tab[0][i] ;				
				}
				if (val > tab[0][j]) {
					tab[0][j] = val;
					System.out.println();
					
				}
				tab[i][j] = val;
			}
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= s.length(); j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println("\n");
		}
		
		for (int i = s.length(); i> 0;) {
			int start = 0;
			for (int j = 1 ;j<s.length();j++) {
				if (tab[j][i] >= tab[start][i]) {
					start = j;
				}
			}
			System.out.println(s.substring(start, i));
			
			i = i - (i-start);
		}
		return 0;
	} 
	
	public static void main(String[] args) {
		Segmentation obj = new Segmentation();
		obj.dic.add("me");
		obj.dic.add("meet");
		obj.dic.add("at");
		obj.dic.add("ate");
		obj.dic.add("eight");	
		obj.dic.add("queen");
		obj.segment("meetmeatthequeen");		
	}
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*public static int numberOfSteps(int[] a) {
    if( a.length==0 ) return 0;

    int min= a[0];
    int total = a[0];
    for(int i=1;i<a.length;i++) {
        if( a[i] < min ) min = a[i];
        total += a[i];
    }

    return total - a.length * min;
}*/

public class WordBreak {
	Set<String> dic = new HashSet<>();
	
	boolean wordBreak(String s) {
		if (this.dic.contains(s)) return true;
		boolean res = false;
		int [][]table = new int[s.length()][s.length()+1];
		table[0][0] = 1;
		for (int i = 0 ;i< s.length() ;i++)
			for (int k = i+1; k<=s.length() ; k++) {
				if (this.dic.contains(s.substring(i, k))) {
					//if (i == 0) {
						//table[i][k] = 1;
					//}
					//else
					if (table[0][i] == 1) {
						table[i][k] = 1;
						if (k == s.length()) res = true;
					}
				}
			}
		
		for (int i =0 ;i<s.length();i++){
			for (int j= 0;j<=s.length();j++) {
				System.out.print(table[i][j]);
			}
		System.out.println("\n");	
		}
		return res;
		/*int [] p = new int[s.length()+1];
		Arrays.fill(p, -1);
		p[0] = 0;
		for (int i = 0 ;i < s.length() ;i++) {
			if (p[i] != -1) {
				for (int j = i+1; j<=s.length() ;j++) {
					if (this.dic.contains(s.substring(i, j))) {
						p[j] = i;
					}
				}
			}
		}
		for (int i = 0;i<= s.length();i++) {
			System.out.print(p[i] + " ");
		}
		return p[s.length()];*/
	}
	
	public static void main(String[] args) {
		WordBreak obj = new WordBreak();
		obj.dic.add("ball");
		obj.dic.add("room");
		obj.dic.add("all");
		obj.dic.add("the");
		String s = "ballroom";
		System.out.println("Last place of substring " + obj.wordBreak(s));
	}
}

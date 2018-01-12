public class baloons {

	int burst(int[] nums, int start,int end) {
		int [][]tab = new int[nums.length][nums.length];
		for (int i = nums.length-1;i>=0 ;i--)
			for (int j = i ; j<nums.length;j++) {
				int max = 1;
				for (int k = i; k<=j;k++) {
					int cost = nums[k];
					if (i-1 < 0);
					else cost = cost*nums[i-1];
					
					if (j+1 >= nums.length);
					else cost = cost*nums[j+1];
					
					if (k-1>=0)
					cost = cost + tab[i][k-1];
					
					if (k+1 < nums.length)
						cost = cost + tab[k+1][j];
					
					if (max < cost) {
						max = cost;
					}
				}
				tab[i][j] = max;
			}

		for (int i =0 ;i<nums.length;i++){
			for (int j= 0;j<nums.length;j++) {
				System.out.print(tab[i][j] + " ");
			}
		System.out.println("\n");	
		}
		return tab[0][nums.length-1];
	}
	
	public static void main(String[] args) {
		baloons obj = new baloons();
		int num[] = {5,2,3,4,1,9,10};
		System.out.println("Mac cost found!! "+ obj.burst(num,0,num.length));
	}
}

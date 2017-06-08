import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int a[] = new int[n];
        int numberOfPairs=0;
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int max_sum=0;
        int maxSume=0;
        int max_start=0;
        int maxnd=0;
        for(int i=0;i<=n-1;i++){
        	max_sum=max_sum+a[i];
        	max_start=i;
        	if(maxSume<max_sum){
        		maxSume=maxSume+max_sum;
        	}else{
        		maxnd=i;
        	}
        }
        System.out.print(numberOfPairs);  
    }
}
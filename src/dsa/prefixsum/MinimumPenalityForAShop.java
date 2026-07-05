package dsa.prefixsum;

import java.util.Scanner;

public class MinimumPenalityForAShop {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string consisting of Y and N where Y means that customers come at the ith hour whereas 'N' indicates that no customers come at the ith hour : ");
        String s = sc.nextLine();

        System.out.println("Earliest hour at which the shop must be closed to incur a minimum penalty is "+ bestClosingTime(s));
    }

    // If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
    //For every hour when the shop is open and no customers come, the penalty increases by 1.
    //For every hour when the shop is closed and customers come, the penalty increases by 1.

    private static int bestClosingTime(String s) {
        int n = s.length();
        int[] pre = new int[n+1]; // for No
        pre[0] = 0;
        for(int i=1; i<=n; i++){
            pre[i] = pre[i-1] + ((s.charAt(i-1) == 'N') ? 1 : 0); // for string it would i-1
        }
        int[] suf = new int[n+1]; // for yes
        suf[n] = 0;
        for(int i=n-1; i>=0; i--){
            suf[i] = suf[i+1] + ((s.charAt(i)=='Y') ? 1 : 0);
        }
        int minPenality = n;
        int hour = -1;
        for(int i=0; i<=n; i++){
            pre[i] += suf[i];
            if(minPenality > pre[i]){
                minPenality = pre[i];
                hour = i;
            }
        }
        return hour;
    }
}
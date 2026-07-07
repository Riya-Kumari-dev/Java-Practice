package dsa.slidingwindow;

import java.util.Scanner;

public class GrumpyBookStoreOwner {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of customers : ");
        int n = sc.nextInt();
        int[] customers = new int[n];
        System.out.print("Enter " + n + " elements for the customers array : ");
        for (int i = 0; i < n; i++) {
            customers[i] = sc.nextInt();
        }

        int[] grumpy = new int[n];
        System.out.print("Enter " + n + " elements for the grumpy array (1 mean he is grumpy 0 means happy) : ");
        for (int i = 0; i < n; i++) {
            grumpy[i] = sc.nextInt();
        }

        System.out.print("Enter his satisfaction time : ");
        int minutes = sc.nextInt();
        System.out.println(" maximum number of customers that can be satisfied throughout the day : "+maxSatisfied(customers, grumpy, minutes));
    }

    private static int  maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unSat = 0; // unsatisfied customers
        int i;
        for(i=0; i<minutes; i++){
            if(grumpy[i] == 1) unSat += customers[i];
        }
        int maxUnSat = unSat;
        int maxIdx = 0;
        i=1;
        int j = minutes;
        while(j<n){
            // grumpy[i] == 1 means customers are unsatisfied at that time because he is grumpy
            // grumpy[i] == 0 means customers are satisfied at that time
            if(grumpy[j] == 1) unSat += customers[j];
            if(grumpy[i-1] == 1) unSat -= customers[i-1];
            if(maxUnSat < unSat){
                maxUnSat = unSat;
                maxIdx = i;
            }
            i++;
            j++;
        }
        // fill the satisfaction with zero in desired slot
        for(int l = maxIdx; l< (maxIdx + minutes) ; l++){
            grumpy[l] = 0;
        }
        int sat = 0; // satisfaction
        for(int l=0; l<n; l++){
            if(grumpy[l] == 0) sat += customers[l];
        }
        return sat;
    }
}

package dsa.binarysearch;

import java.util.Scanner;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products type : ");
        int m = sc.nextInt();
        int[] quantities = new int[m];
        System.out.print("Enter quantities of " + m + " types of product : ");
        for(int i=0; i<m; i++){
            quantities[i] = sc.nextInt();
        }
        System.out.print("Enter the number of retail stores : ");
        int n = sc.nextInt();
        System.out.println("Minimum possible given quantities each store can have is "+minimizedMaximum(quantities, n));
    }

    // You need to distribute all products to the retail stores following these rules:
    //A store can only be given at most one product type but can be given any amount of it.
    //After distribution, each store will have been given some number of products (possibly 0).
    // Let x represent the maximum number of products given to any store. You want x to be as small as possible,
    // i.e., you want to minimize the maximum number of products that are given to any store.

    private static int minimizedMaximum(int[] quantities, int n) {
        int max = Integer.MIN_VALUE;
        for(int ele : quantities) max = Math.max(ele, max);

        int lo = 1;
        int hi = max;
        int ans = hi;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(requiredStores(quantities, mid) <= n){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans;
    }

    private static int requiredStores(int[] quantities, int products) {
        int stores = 0;
        for(int ele : quantities){
//            while(ele > 0){
//                ele -= products;
//                stores ++;
//            }
            if(ele % products == 0) stores += ele/products;
            else stores += ele/products + 1;
        }
        return stores;
    }
}
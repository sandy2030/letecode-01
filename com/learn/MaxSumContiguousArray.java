package com.learn;
public class MaxSumContiguousArray {
    public static void main(String[] args) {
        int a[]={-2,-3, 4, -1, -2, 1, 5, -3};
        int a1[]={-2,3,0,1,-4,5};
        int s[]={-2, 6, -3, -10, 0, 2};
        // -2 -12 36 -360 0 0

        //System.out.println(maxSum(a));

        System.out.println(maxprod(s));
    }
    private static int maxSum(int a[]){
      int max=0;
      int max_so_far=0;
      for (int i=0;i<a.length;i++){
          max=max+a[i];
          if (max<0) max=0;
          if (max_so_far<max)
                  max_so_far=max;
      }
      return max_so_far;
    }

    //    int s[]={-2, 6, -3, -10, 0, 2};
    private static int maxprod(int a[]){
        int max=1;
        int max_so_far=1;
        for (int i=0;i<a.length;i++){
            max=max*a[i];
            if (max<0) max=1;
            if (max_so_far<max)
                max_so_far=max;
        }
        return max_so_far;
    }
}
package com.letecode;

public class BiggestContainer {

    private static int biggestContainer(int [] arr){
        int left=0, right=arr.length-1,height=0,width=0,ans=0,area=0;
        while(left<right){
            height=Math.min(arr[left],arr[right]);
            width=Math.abs(left-right);
            area=height*width;
            ans=Math.max(ans,area);//5
            if (arr[left]<arr[right])
                left++;
            else
                right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1,8,6,2,5,4};
        System.out.println(biggestContainer(arr));
    }
}

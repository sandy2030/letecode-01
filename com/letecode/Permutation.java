package com.letecode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int num[]={1,2,3,4,5};
        List<List<Integer>> permute = permute(num);
        System.out.println(permute);
    }
    static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> resultList=new ArrayList<>();
        backTrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }

    private static void backTrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums) {
        if (tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for (int number:nums){
            if (tempList.contains(number))
                continue;
            tempList.add(number);
            backTrack(resultList,tempList,nums);
            tempList.remove(tempList.size()-1);
        }
    }
}

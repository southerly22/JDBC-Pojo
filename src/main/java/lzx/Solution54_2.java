package lzx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/***
 * @Author: lzx
 * @Description: 三数之和 双指针法
 * @Date: 2023/2/5
 **/
public class Solution54_2 {
    public static void main(String[] args) {
        int[] test = {0,0,0,0};
        int[] test1 = {-1,-1,-1,0,1,1,1,1};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(test);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(Arrays.toString(arrayList.toArray()));
        }

    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        // ArrayList<ArrayList<Integer>> resList = new ArrayList<>();

        HashSet<ArrayList<Integer>> resSet = new HashSet<>(); //利用 hashSet去重

        Arrays.sort(num); //先排序

        for (int i = 0; i < num.length; i++) {

            int left = i+1;
            int right = num.length - 1;
            if (num[i] >0 ) break; //排序了 num[i]>0时 此时三数之和一定 > 0
            if(i>0 && num[i] == num[i-1]) continue; //i去重 (这里尽量不用 i++)

            while (left < right){
                int target = num[i] + num[left] + num[right];
                if (target > 0) right --;
                else if (target < 0) left ++;
                else  {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    Collections.sort(list); //排序是必须的
                    resSet.add(list);
                    left ++;
                    right --;
                    // while (left < right){
                    //     if (num[left]==num[left + 1]) left++; //left去重
                    // }
                    // while (left < right){
                    //     if (num[right]==num[right - 1]) right--; //right去重
                    // }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(resSet);
    }
}

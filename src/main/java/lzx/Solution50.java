package lzx;

import java.util.HashMap;

/***
 * @Author: lzx
 * @Description: 两数之和
 * @Date: 2023/2/5
 **/
public class Solution50 {
    public static void main(String[] args) {
        int[] test = {20, 70, 110, 150};
        int[] res = twoSum2(test, 90);
        for (int r : res) {
            System.out.println(r);
        }
    }
    // todo 方法一：暴力破解
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int ys = target - numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (ys == numbers[j]) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
            }
        }
        return res;
    }
    // todo 方法二：哈希
    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            //将不包含target - numbers[i]，装入map中，包含的话直接返回下标
            if (hashMap.containsKey(target - numbers[i])) {
                res[1] = i+1;
                res[0] = hashMap.get(target - numbers[i])+1;
            }else {
                hashMap.put(numbers[i],i);
            }
        }
        return res;
    }
}

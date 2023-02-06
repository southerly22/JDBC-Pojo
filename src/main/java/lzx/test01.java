package lzx;

import java.util.*;

public class test01 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
        list1.add(1);
        list1.add(2);
        list2.add(2);
        list2.add(1);
        Collections.sort(list1);
        Collections.sort(list2);
        hashSet.add(list1);
        hashSet.add(list2);
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>(hashSet);
        for (ArrayList<Integer> list : resList) {
            System.out.println(list.toString());
        }
        for (ArrayList<Integer> list : hashSet) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
}

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SmallestInfiniteSet {
    public SmallestInfiniteSet() {

    }

    private static Set<Integer> popSet = new HashSet<>();
    private static int smallestNum = 1;

    public int popSmallest() {
        int result = smallestNum;
        popSet.add(smallestNum);
        while (popSet.contains(smallestNum)) {
            smallestNum++;
        }
        return result;
    }

    public void addBack(int num) {
        popSet.remove(num);
        if (num < smallestNum) {
            smallestNum = num;
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet obj = new SmallestInfiniteSet();
//        int param_1 = obj.popSmallest();
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        obj.addBack(2);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        obj.addBack(2);
        obj.addBack(1);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
    }
}

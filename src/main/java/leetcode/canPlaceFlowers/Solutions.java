package leetcode.canPlaceFlowers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyan on 17/6/4.
 */
public class Solutions {

    public static void main(String[] args) {

        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
        System.out.println(canPlaceFlowers(new int[] { 0, 0, 0, 0, 1 }, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        Set<Integer> places = new HashSet<>();
        int[] scanFlowersBed = new int[flowerbed.length + 2];
        scanFlowersBed[0] = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            scanFlowersBed[i + 1] = flowerbed[i];
        }
        scanFlowersBed[scanFlowersBed.length - 1] = 0;
        for (int i = 1; i < scanFlowersBed.length - 1; i++) {
            if (scanFlowersBed[i] != 1 && i - 1 >= 0 && i + 1 < scanFlowersBed.length
                    && scanFlowersBed[i - 1] != 1 && scanFlowersBed[i + 1] != 1) {
                scanFlowersBed[i] = 1;
                places.add(i);
            }
        }
        if (places.size() >= n) {
            return true;
        } else {
            return false;
        }
    }
}

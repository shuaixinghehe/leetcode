package leetcode.minNumberOfHours;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minNumberOfHours(5, 3, new int[] {1, 4, 3, 2}, new int[] {2, 6, 3, 1}));
        System.out.println(minNumberOfHours(2, 4, new int[] {1}, new int[] {3}));
        System.out.println(minNumberOfHours(2, 4, new int[] {1, 1}, new int[] {3, 5}));
        System.out.println(
                minNumberOfHours(94, 70,
                        new int[] {58, 47, 100, 71, 47, 6, 92, 82, 35, 16, 50, 15, 42, 5, 2, 45, 22},
                        new int[] {77, 83, 99, 76, 75, 66, 58, 84, 44, 98, 70, 41, 48, 7, 10, 61, 28}));
        System.out.println(minNumberOfHours(1, 1, new int[] {1, 1, 1, 1}, new int[] {1, 1, 1, 50}));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int needEnergy = 0;
        int needExperience = 0;

        for (int i = 0; i < energy.length; i++) {
            needEnergy += energy[i];
        }
        needEnergy = Math.max(needEnergy - initialEnergy + 1, 0); // 需要大1

        for (int i = 0; i < experience.length; i++) {
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            } else {
                needExperience += experience[i] - initialExperience + 1;
                initialExperience = experience[i] + 1 + experience[i];
            }
        }
        //        System.out.println("needEnergy:" + needEnergy);
        //        System.out.println("needExperience:" + needExperience);
        return needEnergy + needExperience;
    }
}

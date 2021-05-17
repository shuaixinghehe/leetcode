package leetcode.lemonadeChange;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyan on 2018/7/1.
 */
public class Solutions {

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        System.out.println(
                solutions.lemonadeChange(new int[] { 5, 5, 10, 5, 20, 20, 20, 10, 5, 10 }));

    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> canUseMap = new HashMap<>();
        canUseMap.put(20, 0);
        canUseMap.put(10, 0);
        canUseMap.put(5, 0);

        boolean isCanChange = false;
        int needChange = -1;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                canUseMap.put(5, canUseMap.get(5) + 1);
            } else {
                needChange = bills[i] - 5;
                int needChangeV2 = bills[i];
                while (needChange > 0) {
                    int initNeedChange = needChange;
                    if (needChange >= 20 && canUseMap.get(20) > 0) {
                        needChange -= 20;
                        canUseMap.put(20, canUseMap.get(20) - 1);
                    } else if (needChange >= 10 && canUseMap.get(10) > 0) {
                        needChange -= 10;
                        canUseMap.put(10, canUseMap.get(10) - 1);
                    } else if (needChange >= 5 && canUseMap.get(5) > 0) {
                        needChange -= 5;
                        canUseMap.put(5, canUseMap.get(5) - 1);
                    }
                    if (needChange == initNeedChange) {
                        break;
                    }
                }
                if (needChange == 0) {
                    canUseMap.put(needChangeV2, canUseMap.get(needChangeV2) + 1);
                } else {
                    break;
                }
            }

        }
        if (needChange == 0) {
            isCanChange = true;
        }

        return isCanChange;
    }
}

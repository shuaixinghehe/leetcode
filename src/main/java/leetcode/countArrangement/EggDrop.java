package leetcode.countArrangement;

public class EggDrop {
    public static void main(String[] args) {
        System.out.println(f(2, 1, 3));
        System.out.println(reverseWords("  Bob    Loves           Alice   "));
    }

    // 总共N层的楼，在第x层扔掉鸡蛋
    // 有两种情况
    /*
        碎了：
            需要在0  ---   x-1 层进行寻找，并且鸡蛋减一
            value1=f(eggNum-1, 0到(x-1)层)
        没碎：
            需要在x+1 到 N 层进行寻找，鸡蛋不变
            value2=f(eggNum-1,(x+1,N))

        res = min(max(value1,value2))
    * */
    private static int res = Integer.MAX_VALUE;

    private static int f(int eggNum, int startFloorNum, int endFloorNum) {
        if (endFloorNum < startFloorNum || eggNum <= 0) {
            return 0;
        }
        if (eggNum == 1) {  // 如果有1个鸡蛋 只能一个一个试
            return endFloorNum - startFloorNum + 1;
        } else if (endFloorNum == 1 && eggNum >= 1) {
            return 1;
        } else {

            int res = Integer.MAX_VALUE;
            for (int i = startFloorNum; i <= endFloorNum; i++) {
                // 在i 处扔鸡蛋
                int value1 = f(eggNum - 1, startFloorNum, i - 1);
                int value2 = f(eggNum, i + 1, endFloorNum);
                res = Math.min(Math.max(value1, value2) + 1, res);
                return res;
            }
        }
        return 0;
    }

    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] arr = s.split(" ");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("arr[" + i + "]:" + arr[i].length());
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() > 0) {
                builder.append(arr[i] + " ");
            }
        }
//        System.out.println("-" + builder.toString() + "-");
//        System.out.println("-" + builder.substring(0, builder.length() - 1) + "-");
        return builder.substring(0, builder.length() - 1);
    }
}

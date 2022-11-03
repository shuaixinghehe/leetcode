package leetcode.addRungs;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(addRungs(new int[] {1, 3, 5, 10}, 2));
        System.out.println(addRungs(new int[] {3, 6, 8, 10}, 3));
        System.out.println(addRungs(new int[] {3, 4, 6, 7}, 2));
        System.out.println(addRungs(new int[] {5}, 10));
        System.out.println(addRungs(new int[] {3}, 1));
        System.out.println(addRungs(new int[] {4, 8, 12, 16}, 3));
    }

    public static int addRungs(int[] rungs, int dist) {
        int[] newRungs = new int[rungs.length + 1];
        newRungs[0] = 0;
        for (int i = 0; i < rungs.length; i++) {
            newRungs[i + 1] = rungs[i];
        }
        int res = 0;
        int currentRungsPos = newRungs[0];
        for (int i = 1; i < newRungs.length; i++) {
            if (newRungs[i] - currentRungsPos > dist) {
                // 需要插入一个台阶
                int needInsert = 0;
                if ((newRungs[i] - currentRungsPos) % dist == 0) {
                    needInsert = (newRungs[i] - currentRungsPos) / dist - 1;
                } else {
                    needInsert = (newRungs[i] - currentRungsPos) / dist;
                }
                res += needInsert;
                currentRungsPos = Math.max(currentRungsPos + needInsert * dist, newRungs[i]);
            } else {
                currentRungsPos = Math.max(newRungs[i], currentRungsPos);
            }
        }
        return res;
    }
}

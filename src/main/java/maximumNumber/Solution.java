package maximumNumber;

public class Solution {
    public static void main(String[] args) {
        //        System.out.println(maximumNumber("132", new int[] {9, 8, 5, 0, 3, 6, 4, 2, 6, 8}));
        //        System.out.println(maximumNumber("021", new int[] {9, 4, 3, 5, 7, 2, 1, 9, 0, 6}));
        //        System.out.println(maximumNumber("5", new int[] {1, 4, 7, 5, 3, 2, 5, 6, 9, 4}));
        //        System.out.println(maximumNumber("1321231231231", new int[] {9, 8, 5, 0, 3, 6, 4, 2, 6, 8}));
        //        System.out.println(maximumNumber("214010", new int[] {6, 7, 9, 7, 4, 0, 3, 4, 4, 7}));
        //        System.out.println(maximumNumber("334111", new int[] {0, 9, 2, 3, 3, 2, 5, 5, 5, 5}));
        System.out.println(maximumNumber("7218518888806706540", new int[] {5, 1, 5, 3, 1, 9, 5, 2, 0, 5}));
    }

    public static String maximumNumber(String num, int[] change) {
        StringBuilder builder = new StringBuilder();
        boolean isValid = true;
        boolean isEqual = false;
        boolean isRun = false;
        for (int i = 0; i < num.length(); ) {
            int value = num.charAt(i) - '0';
            while (value > change[value] && i < num.length()) {
                builder.append(value);
                i++;
                if (i < num.length()) {
                    value = num.charAt(i) - '0';
                }
//                if (isRun)
            }

            isRun = false;
            while (value < change[value] && i < num.length() && isValid) {
                builder.append(change[value]);
                i++;
                if (i < num.length()) {
                    value = num.charAt(i) - '0';
                    isRun = true;
                }
            }

            if (isRun) {
                isValid = false;
            }
            isEqual = false;
            while (value == change[value] && i < num.length()) {
                builder.append(value);
                isEqual = true;
                if (isValid == false) {
                    isValid = true;
                }
                i++;
                if (i < num.length()) {
                    value = num.charAt(i) - '0';
                }
            }
            while (!isValid && i < num.length() && !isEqual) {
                value = num.charAt(i) - '0';
                builder.append(value);
                i++;
            }
        }
        return builder.toString();
    }
}

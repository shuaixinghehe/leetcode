import java.util.Stack;

public class minswap {
    public static void main(String[] args) {
        System.out.println(minSwaps("][]["));
        System.out.println(minSwaps("]]][[["));
    }

    public static int minSwaps(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (stack.isEmpty() || character.equals('[')) {
                stack.add(character);
            } else {
                if (character.equals(']')) {
                    if (stack.peek().equals('[')) {
                        stack.pop();
                    } else {
                        stack.add(character);
                    }
                }
            }

        }
        res = (int) Math.ceil((int) (stack.size() / 2.0) / 2.0);
        return res;
    }
}

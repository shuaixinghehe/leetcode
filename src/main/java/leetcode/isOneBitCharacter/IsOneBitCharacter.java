package leetcode.isOneBitCharacter;

/**
 * Created by luyan on 17/10/29.
 */
public class IsOneBitCharacter {

    public static void main(String[] args) {
        IsOneBitCharacter isOneBitCharacter = new IsOneBitCharacter();
        System.out.println(isOneBitCharacter.isOneBitCharacter(new int[] { 1, 0, 0, 1, 0 }));
        System.out.println(isOneBitCharacter.isOneBitCharacter(new int[] { 1, 0, 1, 1, 0 }));
    }

    public boolean isOneBitCharacter(int[] bits) {

        if (bits.length == 1) {
            return true;
        }
        if (bits.length == 2) {
            if (bits[0] == 1) {
                return false;
            }
            return true;
        }
        if (bits.length >= 3) {
            if (bits[bits.length - 2] == 0 && bits[bits.length - 1] == 0) {
                return true;
            }
            if (bits[bits.length - 2] == 1 && bits[bits.length - 1] == 0) {
                if (bits[bits.length - 3] == 0) {
                    return false;
                }
                int cnt1 = 0;
                for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
                    cnt1++;
                }
                if (cnt1 % 2 == 0) {

                    return true;
                } else {
                    return false;
                }
            }

        }
        return false;
    }
}

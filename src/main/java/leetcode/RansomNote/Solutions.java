package leetcode.RansomNote;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyan on 17/1/19.
 */
public class Solutions {

    public static void main(String[] args) {
        String ransomNote = "";
        String magazine = "";
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNodeArr = ransomNote.toCharArray();
        char[] magazineArr = magazine.toCharArray();
        Map<Character, Integer> origin = new HashMap<>();

        for (int i = 0; i < magazineArr.length; i++) {
            if (origin.containsKey(magazineArr[i])) {
                int value = origin.get(magazineArr[i]);
                origin.put(magazineArr[i], ++value);
            } else {
                origin.put(magazineArr[i], 1);
            }
        }

        for (int i = 0; i < ransomNodeArr.length; i++) {
            if (origin.containsKey(ransomNodeArr[i])) {
                int value = origin.get(ransomNodeArr[i]);
                if (value > 0) {
                    origin.put(ransomNodeArr[i], --value);

                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

}

package leetcode.FirstUniqueCharacterinaString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyan on 17/1/20.
 */
public class Solutions {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
        s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int count = map.get(chars[i]);
                map.put(chars[i], ++count);
            } else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

}

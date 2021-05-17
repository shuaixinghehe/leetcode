package leetcode.LongestWordinDictionary720;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luyan on 17/11/5.
 */
public class LongestWordinDictionary {

    public static void main(String[] args) {
        LongestWordinDictionary longestWordinDictionary = new LongestWordinDictionary();
        longestWordinDictionary
                .longestWord(new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" });

    }

    private boolean isBuildOneWord(String shortStr, String longStr) {
        /*        if()
        if (shortStr.length()) if (shortStr.equals(longStr.substring(0, shortStr.length() - 1))) {
            return true;
        }*/
        return false;
    }

    public String longestWord(String[] words) {
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (wordsMap.containsKey(words[i])) {
                wordsMap.put(words[i], wordsMap.get(words[i]) + 1);
            } else {
                wordsMap.put(words[i], 1);
                arrayList.add(words[i]);
            }
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        return "a";
    }
}

package leetcode.decodeTheMessage;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static String decodeMessage(String key, String message) {
        key = key.replace("\\ ", "");
        Map<Character, Character> map = new TreeMap<>();
        int alphabetCnt = 0;
        for (int i = 0; i < key.length(); i++) {
            Character character = new Character(key.charAt(i));
            if (character != ' ' && !map.containsKey(character)) {
                map.put(character, Character.valueOf((char) ('a' + alphabetCnt)));
                alphabetCnt++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                builder.append(' ');
            } else {
                builder.append(map.get(message.charAt(i)));
            }

        }
//        System.out.println(builder.toString());
        return builder.toString();
    }

    public static void main(String[] args) {
        decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb");
    }
}

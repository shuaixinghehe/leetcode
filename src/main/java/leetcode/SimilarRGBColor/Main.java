package leetcode.SimilarRGBColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyan on 18/3/18.
 */
public class Main {

    private static List<String> list = new ArrayList<String>() {

        {
            add("00");
            add("11");
            add("22");
            add("33");
            add("44");
            add("55");
            add("66");
            add("77");
            add("88");
            add("99");
            add("aa");
            add("bb");
            add("cc");
            add("dd");
            add("ee");
            add("ff");
        }
    };

    public static void main(String[] args) {
        System.out.println(similarRGB("#09f166"));
    }

    private static double similatiry(String colorA, String colorB) {
        return Math
                .pow(Integer.valueOf(colorA.substring(1, 2), 16) * 1.0
                        - Integer.valueOf(colorB.substring(1, 2), 16) * 1.0, 2.0)
                + Math.pow(Integer.valueOf(colorA.substring(3, 4), 16) * 1.0
                        - Integer.valueOf(colorB.substring(3, 4), 16) * 1.0, 2.0)
                + Math.pow(Integer.valueOf(colorA.substring(5, 6), 16) * 1.0
                        - Integer.valueOf(colorB.substring(5, 6), 16) * 1.0, 2.0);
    }

    private static int powHex(String a, String b) {
        //        System.out.println("a:" + a + " b:" + b);
        return (Integer.valueOf(a, 16) - Integer.valueOf(b, 16))
                * (Integer.valueOf(a, 16) - Integer.valueOf(b, 16));
    }

    public static String similarRGB(String color) {
        //        String r = color.substring(1, 2);
        //        String g = color.substring(3, 4);
        //        String b = color.substring(5, 6);
        String minColor = "";
        String result = "#";
        Double minsimilarity = Double.MAX_VALUE;
        //        System.out.println(minsimilarity);

        for (int i = 0; i < list.size(); i++) {
            double tmpSimilarity = powHex(list.get(i), color.substring(1, 3));
            if (tmpSimilarity < minsimilarity) {
                minsimilarity = tmpSimilarity;
                minColor = list.get(i);
            }
        }
        result += minColor;
        //        System.out.println("minColor:" + minColor);
        minsimilarity = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            StringBuilder colorA = new StringBuilder();
            double tmpSimilarity = powHex(list.get(i), color.substring(3, 5));
            if (tmpSimilarity < minsimilarity) {
                minsimilarity = tmpSimilarity;
                minColor = list.get(i);
            }
        }
        //        System.out.println("minColor:" + minColor);
        result += minColor;
        minsimilarity = Double.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            StringBuilder colorA = new StringBuilder();
            double tmpSimilarity = powHex(list.get(i), color.substring(5, 7));
            if (tmpSimilarity < minsimilarity) {
                minsimilarity = tmpSimilarity;
                minColor = list.get(i);
            }
        }
        result += minColor;
        return result;
    }
}

package leetcode.findDuplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luyan on 17/6/4.
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new String[] {
                "root/cflrodi/irrgfoyzwbj/q/rjytmebdlzcdakl/eozikpwsempmhuf/qaipsnreapdgye/n/kf/zq udosmfn.txt(lnmahafnssgsrgnkfosaasgyq) sditog.txt(tsuxooqqlmbrewwpysatghuowmmucqhzodpvrvhul) kwkmqvtxtnw.txt(oeqaxwnzbkowwhrwwmxfbzrqqeuxvdijtnwybyfsihb) gj.txt(oeqaxwnzbkowwhrwwmxfbzrqqeuxvdijtnwybyfsihb) khrct.txt(wrrajcclaeuzgiivqhjxjyt)" }));
        System.out.println(findDuplicate(new String [] {
                "root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"
        }));
    }

    public static List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String[] detail = paths[i].split(" ");
            String path = detail[0];
            for (int j = 1; j < detail.length; j++) {
                String[] contentDetail = detail[j].split("txt\\(");
                String fileName = contentDetail[0] + "txt";
                String content = contentDetail[1];
                if (map.containsKey(content)) {
                    map.get(content).add(path + "/" + fileName);
                } else {
                    map.put(content, new ArrayList<>());
                    map.get(content).add(path + "/" + fileName);
                }
            }
        }

        List<List<String>> dupList = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                dupList.add(map.get(key));
            }
        }
        return dupList;
    }
}

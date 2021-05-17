package VM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyan on 2019/11/21.
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObjcet> list = new ArrayList<>();
        System.out.println("test HeapOOM");
        while (true) {
            list.add(new OOMObjcet());
        }
    }

    static class OOMObjcet {
    }
}

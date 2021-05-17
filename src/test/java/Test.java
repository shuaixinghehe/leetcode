import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyan on 2018/10/26.
 */
public class Test {
    public static void main(String[] args) {
        String text = "12345";
        Set<Integer> uniqueCharSet = new HashSet<>();
        for (int i = 0; i < text.length(); ++i) {
            uniqueCharSet.add(text.codePointAt(i));
        }

        System.out.println(text.codePointAt(1));
        System.out.println(text.charAt(1));
    }
}

package task1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerTask1 {

    public static void main(String[] args) {
        List<String[]> rows = new ArrayList<String[]>();
        String[] foo = new String[]{"a", "b", "c"};
        String[] bar = new String[]{"", null, "c"};
        String[] number = new String[]{"1", "2", "2c3"};


        rows.add(foo);
        System.out.println(Arrays.toString(foo));

        Task1Impl.getInstance().sort(rows, 1);
    }

}

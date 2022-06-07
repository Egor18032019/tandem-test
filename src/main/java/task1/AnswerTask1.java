package task1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerTask1 {

    public static void main(String[] args) {
        List<String[]> rows = new ArrayList<String[]>();
        String[] foo =    new String[]{"a", "b", "c"};
        String[] bar =    new String[]{"", null, "ф"};
        String[] number = new String[]{"1", "2", "2c3"};
        int columnIndex = 1;

        rows.add(foo);
        rows.add(bar);
        rows.add(number);
        System.out.println(Arrays.toString(rows.get(columnIndex)));
        Task1Impl.getInstance().sort(rows, 1);
        System.out.println(Arrays.toString(rows.get(columnIndex)));
    }
    /*
        Comparator возвращает int по следующей схеме:
        отрицательный int (первый объект меньше)
        положительный int (первый объект больше)
        ноль = объекты равны
         */
}

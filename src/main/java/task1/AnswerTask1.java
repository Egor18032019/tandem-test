package task1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerTask1 {

    public static void main(String[] args) {
        List<String[]> rows = new ArrayList<String[]>();
        String[] empty = new String[] {""  , " "  , ""};
        String[] foo = new String[]   {"A" , "  " , "2"};
        String[] bar = new String[]   {"  ",  null, "2c4"};
        String[] number = new String[]{"1" , "2"  , "1c2"};
        int columnIndex = 2;
        rows.add(foo);
        rows.add(bar);
        rows.add(number);
        rows.add(empty);
        Task1Impl.getInstance().sort(rows, columnIndex);
        for (String[] piece : rows) {
            System.out.println(Arrays.toString(piece));
        }
    }
    /*
        Comparator возвращает int по следующей схеме:
        отрицательный int (первый объект меньше)
        положительный int (первый объект больше)
        ноль = объекты равны
         */
}

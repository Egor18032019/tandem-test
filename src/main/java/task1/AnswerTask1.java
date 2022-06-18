package task1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerTask1 {

    public static void main(String[] args) {
        List<String[]> rows = new ArrayList<String[]>();
        String[] number1 = new String[]{"4",  "200qweqwe"};
        String[] number2 = new String[]{"6",  "123qwe21ee"};
        String[] number3 = new String[]{"7",  "123"};
        String[] number31 = new String[]{"71","123"};
        String[] number4 = new String[]{"8",  "124qwe21eew"};
        String[] number5 = new String[]{"9",  "12qwe21e"};
        String[] number6 = new String[]{"10", "1eeqwe21w"};
        String[] number7 = new String[]{"11", "qwe123qww"};
        String[] number8 = new String[]{"12", "qwe12qwew"};
        int columnIndex = 1;
        rows.add(number1);
        rows.add(number2);
        rows.add(number3);
        rows.add(number31);
        rows.add(number4);
        rows.add(number5);
        rows.add(number6);
        rows.add(number7);
        rows.add(number8);
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

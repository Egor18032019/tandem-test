package task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RowsComparator implements Comparator<String[]> {
    private final int index;

    public RowsComparator(int columnIndex) {
        this.index = columnIndex;
    }

    @Override
    public int compare(String[] o1, String[] o2) {
        Integer compare_result = null;
// в колонке могут быть null и пустые значения
// - строки с null-значениями должны быть первыми,
// - затем строки с пустым значением, затем все остальные,</li>
        // сначала проверили на null и пустоту
        System.out.println("o1 - " + o1[index]);

        System.out.println("o2 - " + o2[index]);

//        System.out.println(o1[index].isEmpty());

        boolean isNullOrEmpty =
                (o1[index] == null
                        || o1[index].isEmpty()
                        || o2[index] == null
                        || o2[index].isEmpty());
        System.out.println("isNullOrEmpty " + isNullOrEmpty);
        if (isNullOrEmpty) {
            if (o1[index] == null && o2[index] == null) return 0;
            if (o1[index].isEmpty() && o2[index].isEmpty()) return 0;
            if (o1[index] == null && o2[index].isEmpty()) return -1;
            if (o1[index].isEmpty() && o2[index] == null) return 1;
            if (o1[index] == null) return -1;
            if (o2[index] == null) return 1;
            if (o1[index].isEmpty()) return -1;
            if (o2[index].isEmpty()) return 1;
        }  // если пришло null и строка

// строка бьется на подстроки следующим образом:
// выделяем непрерывные максимальные фрагменты строки,
// состоящие только из цифр,
// и считаем набором подстрок эти фрагменты
// и все оставшиеся от такого разбиения фрагменты строки

        List<String> list_str_1 = splitter(o1[index]);
        List<String> list_str_2 = splitter(o2[index]);
        System.out.println(" после разбиения ");
        System.out.println(list_str_1);
        System.out.println(list_str_2);
        Iterator<String> fragment_1 = list_str_1.iterator();
        Iterator<String> fragment_2 = list_str_2.iterator();
        while (true) {
            String piece_1 = fragment_1.next();
            String piece_2 = fragment_2.next();
//если обе подстроки состоят из цифр
// - то при сравнении они интерпретируются как целые числа (вначале должно идти меньшее число),
            if (isNumber(piece_1) && isNumber(piece_2)) {
                int int_from_piece_1 = Integer.parseInt(piece_1);
                int int_from_piece_2 = Integer.parseInt(piece_2);
                if (int_from_piece_1 == int_from_piece_2) continue;
                else compare_result = int_from_piece_1 - int_from_piece_2;
                break;
            }
// в противном случае - как строки
//            else if (isNumber(piece_1) || isNumber(piece_2)) { // если обе строки ?
            // так что тут уже сравниваем то и другое как строки
            else {
                compare_result = piece_1.compareTo(piece_2);
            }
        }

        return compare_result;
    }

    ;


    private boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.valueOf(str);
        } catch (NumberFormatException e3) {
            return false;
        }
        return true;
    }

    public List<String> splitter(final String str) {
        System.out.println("splitter");
        System.out.println(str);
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+|\\D+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }
}

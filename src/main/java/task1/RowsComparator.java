package task1;

import java.util.*;
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
        String str_1 = o1[index];
        String str_2 = o2[index];
        boolean isHaveNull = (str_1 == null || str_2 == null);

        if (isHaveNull) {
            if (str_1 == null && str_2 == null) return 0;
            if (str_1 == null) return -1;
            if (str_2 == null) return 1; // для наглядности
        } else {
            if (str_1.equals("") && str_2.equals("")) return 0;
            if (str_1.equals("")) return -1;
            if (str_2.equals("")) return 1;
            if (str_1.trim().equals("")) return -1;
            if (str_2.trim().equals("")) return 1;
        }
// строка бьется на подстроки следующим образом:
// выделяем непрерывные максимальные фрагменты строки,
// состоящие только из цифр,
// и считаем набором подстрок эти фрагменты
// и все оставшиеся от такого разбиения фрагменты строки
        List<String> list_str_1 = splitter(str_1);
        List<String> list_str_2 = splitter(str_2);

        Iterator<String> fragment_1 = list_str_1.iterator();
        Iterator<String> fragment_2 = list_str_2.iterator();

        while (true) {
            String piece_1;
            boolean isLastOnF1 = !fragment_1.hasNext();
            boolean isLastOnF2 = !fragment_2.hasNext();
            if (isLastOnF1 && isLastOnF2) {
                compare_result = 0;
                break;
            }
            if (isLastOnF1) {
                compare_result = -1;
                break;
            } else {
                piece_1 = fragment_1.next();
            }
            String piece_2;
            if (isLastOnF2) {
                compare_result = 1;
                break;
            } else {
                piece_2 = fragment_2.next();
            }
//если обе подстроки состоят из цифр
// - то при сравнении они интерпретируются как целые числа (вначале должно идти меньшее число),
            if (isNumber(piece_1) && isNumber(piece_2)) {
                int int_from_piece_1 = Integer.parseInt(piece_1);
                int int_from_piece_2 = Integer.parseInt(piece_2);
                if (int_from_piece_1 == int_from_piece_2) {
                    compare_result = 0;
                    continue;
                } else {
                    compare_result = int_from_piece_1 - int_from_piece_2;
                    break;
                }
            }
            // если какой нить из двоих число
            else if (isNumber(piece_1) || isNumber(piece_1)) {
                compare_result = isNumber(piece_1) ? -1 : 1;
                break;
            }
            // если оба строки
            // только один вариант остался -> две строки
            else {
// в противном случае - как строки
                if (!piece_1.equals(piece_2)) {
                    compare_result = piece_1.compareTo(piece_2);
                    break;
                } else {
                    // если обе строки равны -> то смотрим что дальше
                    continue;
                }
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
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+|\\D+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }
}

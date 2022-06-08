package task1;

import task2.Task2Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

///**
// * <h1>Задание №1</h1>
// * Реализуйте интерфейс {@link IStringRowsListSorter}.
// *
// * <p>Мы будем обращать внимание в первую очередь на структуру кода и владение стандартными средствами java.</p>
// */
public class Task1Impl implements IStringRowsListSorter {
    public static Task1Impl INSTANCE;

    public Task1Impl() {
    }

    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static synchronized Task1Impl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Task1Impl();
        }
        return INSTANCE;
    }

    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {
        // напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода.
        // проверки
        if (rows == null || rows.size() == 0) {
            throw new RuntimeException(
                    "Empty list.");
        }
        if (columnIndex < 0) {
            throw new RuntimeException("Column index must > 0");
        }
        if (columnIndex >= rows.size()) {
            throw new RuntimeException("The index cannot be longer than the length of the list");
        }
        Collections.sort(rows,
                new RowsComparator(columnIndex));
    }
}

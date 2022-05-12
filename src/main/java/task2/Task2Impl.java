package task2;

import java.util.*;

/**
 * <h1>Задание №2</h1>
 * Реализуйте интерфейс {@link IElementNumberAssigner}.
 *
 * <p>Помимо качества кода, мы будем обращать внимание на оптимальность предложенного алгоритма по времени работы
 * с учетом скорости выполнения операции присвоения номера:
 * большим плюсом (хотя это и не обязательно) будет оценка числа операций, доказательство оптимальности
 * или указание области, в которой алгоритм будет оптимальным.</p>
 */
public class Task2Impl implements IElementNumberAssigner {
    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static Task2Impl instance;

    public Task2Impl() {
    }

    public static synchronized Task2Impl getInstance() {
        if (instance == null) {
            instance = new Task2Impl();
        }
        return instance;
    }


    @Override
    public void assignNumbers(final List<IElement> elements) {
        // напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода, работающего за разумное время.
        if (elements == null || elements.isEmpty()) {
            throw new RuntimeException(
                    "Empty list.");
        }
        List<Integer> storage = new ArrayList<>();
        for (IElement e : elements) {
            storage.add(e.getNumber());
        }
        int freeSwapNumber = getFreeSwapNumber(storage) + 1;
//        [4,0,1,2,5]
        System.out.println(storage);
        for (int i = 0; i < elements.size(); i++) {
            int currentNumberForElement = elements.get(i).getNumber();
            if (currentNumberForElement != i) {
                int index = storage.indexOf(i);
                if (index != -1) {
                    storage.remove(i);
                    storage.add(index, freeSwapNumber);
                    elements.get(index).setupNumber(freeSwapNumber);
                    freeSwapNumber++;
                }
                elements.get(i).setupNumber(i);
            }
        }

    }

    private int getFreeSwapNumber(List<Integer> storage) {
        Integer max = storage.stream()
                .max((a, b) -> {
                    if (a > b) return 1;
                    else if (a < b) return -1;
                    else return 0;
                }).get();
        return max;
    }


}

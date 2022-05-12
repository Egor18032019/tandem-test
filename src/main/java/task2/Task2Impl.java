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
    public static final IElementNumberAssigner INSTANCE = new Task2Impl();
    //TODO final ?

    @Override
    public void assignNumbers(final List<IElement> elements) {
        // напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода, работающего за разумное время.
        List<Integer> storage = new ArrayList<>();
        for (IElement e : elements) {
            storage.add(e.getNumber());
        }
        int freeSwapNumber = getFreeSwapNumber(storage)+1;
//        [4,0,1,2,5]
        System.out.println(storage);
        for (int i = 0; i < elements.size(); i++) {
            int currentNumberForElement = elements.get(i).getNumber();
            if (currentNumberForElement != i) {

                if (storage.contains(i)) {
                    int index = storage.indexOf(i);
                    System.out.println("i - " + i);
                    System.out.println("index - " + index);
                    System.out.println("freeSwapNumber - " + freeSwapNumber);
                    storage.remove(i);
                    storage.add(index,freeSwapNumber);
                    elements.get(index).setupNumber(freeSwapNumber);
                    freeSwapNumber++;
                }
                elements.get(i).setupNumber(i);
            }
        }
        List<Integer> storage2 = new ArrayList<>();
        for (IElement e : elements) {
            storage2.add(e.getNumber());
        }
        System.out.println(storage2);
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

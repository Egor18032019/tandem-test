package task2;

import java.util.*;
import java.util.stream.Collectors;

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
        List<Integer> storageNoSorted = new ArrayList<>();
        for (IElement e : elements) {
            storageNoSorted.add(e.getNumber());
        }
        List<Integer> storageSorted = storageNoSorted.stream().sorted()
                .collect(Collectors.toList());

        int freeSwapNumber = getFreeSwapNumber(storageNoSorted);
        for (int i = 0; i < elements.size(); i++) {
            int currentNumberForElement = elements.get(i).getNumber();
            int rightNumber = storageSorted.get(i);
            boolean isRightElemenent = currentNumberForElement == rightNumber;
            if (!isRightElemenent) {
// на протяжении всей работы метода обеспечивается уникальность номеров элементов:
// ищем индекс элемента storageNoSorted что является аналогом elements
                int index = storageNoSorted.indexOf(rightNumber);
                boolean haveItemInStorageNoSorted = index != -1;
                if (haveItemInStorageNoSorted) {
                    elements.get(index).setupNumber(freeSwapNumber);
                    storageNoSorted.set(index, freeSwapNumber);
                    freeSwapNumber++;
                }
                storageNoSorted.set(i, freeSwapNumber);
                freeSwapNumber++;
                elements.get(i).setupNumber(rightNumber);
            }
        }
        List<Integer> storage3 = new ArrayList<>();
        for (IElement e : elements) {
            storage3.add(e.getNumber());
        }
        System.out.println(storage3);
    }

    private int getFreeSwapNumber(List<Integer> storage) {
        Integer max = storage.stream()
                .max((a, b) -> {
                    if (a > b) return 1;
                    else if (a < b) return -1;
                    else return 0;
                }).get();
        return max + 1;
    }
}

//        List<IElement> storageSorted = elements.stream().sorted(
//                (f1, f2) -> Integer.compare(f1.getNumber(), f2.getNumber())
//        ).collect(Collectors.toList());
//        Collections.sort(storageNoSorted); //отсортировали
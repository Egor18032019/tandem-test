package task2;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    public static void main(String[] args) {
        ElementExampleImpl test = new ElementExampleImpl(new ElementExampleImpl.Context(), 8);
        ElementExampleImpl test1 = new ElementExampleImpl(new ElementExampleImpl.Context(), 23);
        ElementExampleImpl test2 = new ElementExampleImpl(new ElementExampleImpl.Context(), 1);
        ElementExampleImpl test3 = new ElementExampleImpl(new ElementExampleImpl.Context(), -4);
        ElementExampleImpl test4 = new ElementExampleImpl(new ElementExampleImpl.Context(), 3);
        ElementExampleImpl test5 = new ElementExampleImpl(new ElementExampleImpl.Context(), 2);
        ElementExampleImpl test6 = new ElementExampleImpl(new ElementExampleImpl.Context(), 4);

        List<IElement> elements = new ArrayList<>();
        elements.add(test);
        elements.add(test1);
        elements.add(test2);
        elements.add(test3);
        elements.add(test4);
        elements.add(test5);
        elements.add(test6);
        IElementNumberAssigner answer = new Task2Impl();
        answer.assignNumbers(elements);
    }
}

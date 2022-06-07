package task1;

import java.util.Comparator;

public class RowsComparator implements Comparator<String[]> {
    private final int columnIndex;

    public RowsComparator(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    @Override
    public int compare(String[] o1, String[] o2) {
        return 0;
    }
}

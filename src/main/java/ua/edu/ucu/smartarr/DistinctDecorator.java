package ua.edu.ucu.smartarr;

import java.util.ArrayList;

public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    private Object[] deleteRepeats() {
        Object[] arr = smartArray.toArray();
        ArrayList<Object> noRepeats = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (!arr[i].equals(arr[j]) && !noRepeats.contains(arr[i])) {
                    noRepeats.add(arr[i]);
                }
            }
        }
        return noRepeats.toArray();
    }

    @Override
    public Object[] toArray() {
        return deleteRepeats();
    }

    @Override
    public String operationDescription() {
        return "Deleted the same";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}

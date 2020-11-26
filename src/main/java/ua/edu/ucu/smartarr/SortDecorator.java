package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator func;
    public SortDecorator(SmartArray smartArray, MyComparator func) {
        super(smartArray);
        this.func = func;

    }
    @Override
    public Object[] toArray() {
        return Arrays
                .stream(smartArray.toArray()).sorted(func).toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorted!";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}

package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

public class FilterDecorator extends SmartArrayDecorator {
    MyPredicate predicate;
    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).filter(predicate::test).toArray();
    }

    @Override
    public String operationDescription() {
        return "Filtered!";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}

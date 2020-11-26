package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

public class MapDecorator extends SmartArrayDecorator{
    MyFunction function;
    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).map(function::apply).toArray();
    }

    @Override
    public String operationDescription() {
        return "Function applied!";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}

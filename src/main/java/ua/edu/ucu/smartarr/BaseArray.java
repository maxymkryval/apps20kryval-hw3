package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {

    private final Object[] arr;
    public BaseArray(Object[] array) {
        this.arr = array.clone();
    }

    @Override
    public Object[] toArray() {
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return "Regular Array";
    }

    @Override
    public int size() {
        return arr.length;
    }
}

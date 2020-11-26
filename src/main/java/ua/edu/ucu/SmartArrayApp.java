package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = t -> ((Integer) t) > 0;

        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);

        MyFunction func = t -> 2 * ((Integer) t);

        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname
            (Student[] students) {

        SmartArray smartArray = new BaseArray(students);
        MyPredicate pred = t -> ((Student) t).getGPA() >= 4
                && ((Student) t).getYear() == 2;

        MyComparator cmp = (st1, st2) -> ((Student) st1).getSurname().compareTo(((Student) st2).getSurname());

        MyFunction func = t -> ((Student) t).getSurname() + " " + ((Student) t).getName();

        smartArray = new MapDecorator(new DistinctDecorator(new FilterDecorator(
                new SortDecorator(smartArray, cmp), pred)), func);
        Object[] filtered = smartArray.toArray();
        return Arrays.copyOf(filtered, filtered.length, String[].class);
    }
    }

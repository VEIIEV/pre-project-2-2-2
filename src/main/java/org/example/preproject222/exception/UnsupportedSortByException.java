package org.example.preproject222.exception;

import java.util.ArrayList;
import java.util.List;


//хотел сначала наследоваться от BindException но чёт не разобрался как им пользоваться
public class UnsupportedSortByException extends RuntimeException {

    private final List<String> usedSortBy = new ArrayList<>();

    public UnsupportedSortByException(String message) {
        super(message);
    }

    public UnsupportedSortByException(String message, List<String> unsupportedSorts) {
        super(message);
        usedSortBy.addAll(unsupportedSorts);
    }

    public void addUsedUnsupportedSortBy(String sortBy) {
        usedSortBy.add(sortBy);
    }

    public List<String> getUsedSortBy() {
        return usedSortBy;
    }
}

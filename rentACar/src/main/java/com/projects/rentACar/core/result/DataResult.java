package com.projects.rentACar.core.result;

public class DataResult<T> extends Result {

    private T data;

    public DataResult(boolean success) {
        super(success);
    }

    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(boolean success, String message) {
        super(success, message);
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }


    public T getData() {
        return this.data;
    }
}

package com.denys_bereza.test_app.dto;

public class GenericResponse<T> {
    protected Boolean success;
    protected String message;

    protected T data;

    public GenericResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public GenericResponse<T> withData(T data) {
        this.data = data;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


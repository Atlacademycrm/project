package com.atlacademy.crm.response;

public class BaseResponse {
    private int statusCode;
    private String errorMessage;
    private Object object;

    // For success response
    public BaseResponse(Object object) {
        this.object = object;
    }

    // For custom response
    public BaseResponse(Object object, int statusCode, String errorMessage) {
        this.object = object;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    //For error response
    public BaseResponse(int statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


}

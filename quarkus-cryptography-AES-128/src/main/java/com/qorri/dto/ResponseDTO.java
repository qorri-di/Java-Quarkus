package com.qorri.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {
    private String status;
    private int code;
    private String message;
    private T data;

    @JsonIgnore
    public ResponseDTO<T> successResponse(String msg) {
        ResponseDTO<T> data = new ResponseDTO();
        data.setStatus("Success");
        data.setCode(201);
        data.setMessage(msg);
        return data;
    }

    @JsonIgnore
    public ResponseDTO<T> successResponse(T t, String msg) {
        ResponseDTO<T> data = new ResponseDTO();
        data.setStatus("Success");
        data.setCode(201);
        data.setData(t);
        data.setMessage(msg);
        return data;
    }

    @JsonIgnore
    public ResponseDTO<T> noDataFoundResponse(T t) {
        ResponseDTO<T> data = new ResponseDTO();
        data.setStatus("Success");
        data.setCode(204);
        data.setData(t);
        data.setMessage("No Data Found");
        return data;
    }

    @JsonIgnore
    public ResponseDTO<T> noDataFoundResponse() {
        ResponseDTO<T> data = new ResponseDTO();
        data.setStatus("Success");
        data.setCode(204);
        data.setMessage("No Data Found");
        return data;
    }

    @JsonIgnore
    public ResponseDTO<T> errorResponse(int code, String message) {
        ResponseDTO<T> data = new ResponseDTO();
        data.setStatus("Failed");
        data.setCode(code);
        data.setMessage(message);
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return this.status;
    }


    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public ResponseDTO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseDTO(String status, int code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

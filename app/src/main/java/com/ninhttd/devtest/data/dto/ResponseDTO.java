package com.ninhttd.devtest.data.dto;

import lombok.Getter;
import lombok.Setter;

public class ResponseDTO<DTO> extends StatusDTO {
    private String errors;

    private DTO result;

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public DTO getResult() {
        return result;
    }

    public void setResult(DTO result) {
        this.result = result;
    }

    public String getErrors() {
        return errors;
    }
}

package com.ninhttd.devtest.data.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseDTO<DTO> implements Serializable {
    private String errors;

    private DTO result;

    @SerializedName("extra")
    private ExtraDTO extra;

    @SerializedName("code")
    private CodeDTO code;

    public CodeDTO getCode() {
        return code;
    }

    public void setCode(CodeDTO code) {
        this.code = code;
    }

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

    public ExtraDTO getExtra() {
        return extra;
    }

    public void setExtra(ExtraDTO extra) {
        this.extra = extra;
    }
}

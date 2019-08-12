package com.ninhttd.devtest.data.dto;

import com.google.gson.annotations.SerializedName;

public class ResponseDTO<DTO> extends StatusDTO {
    private String errors;

    private DTO result;

    @SerializedName("extra")
    private ExtraDTO extra;

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

package com.ninhttd.devtest.data.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class StatusDTO implements Serializable {
    @Setter
    @Getter
    private Boolean success;
    @Setter
    @Getter
    private String message;
}

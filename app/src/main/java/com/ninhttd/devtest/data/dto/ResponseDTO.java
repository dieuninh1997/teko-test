package com.ninhttd.devtest.data.dto;

import lombok.Getter;
import lombok.Setter;

public class ResponseDTO<DTO> extends StatusDTO {
    @Setter
    @Getter
    private String errors;

    @Getter
    @Setter
    private DTO result;
}

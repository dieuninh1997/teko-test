package com.ninhttd.devtest.data.dto;

import lombok.Getter;
import lombok.Setter;

public class ViewDTO extends StatusDTO {
    @Setter
    @Getter
    int id;

    @Getter
    @Setter
    String name;

    @Setter
    @Getter
    int deleted;

    @Setter
    @Getter
    String created_at;

    @Setter
    @Getter
    String updated_at;

    public ViewDTO(String name) {
        this.name = name;
    }
}

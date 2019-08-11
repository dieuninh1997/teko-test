package com.ninhttd.devtest.data.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ResponseListDTO<DTO> extends StatusDTO {

    private List<DTO> results;


    public List<DTO> getResults() {
        return results;
    }

    public void setResults(List<DTO> results) {
        this.results = results;
    }
}

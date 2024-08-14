package org.scoula.ex03.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SampleDTOList {
    private List<SampleDTO> list;

    public SampleDTOList() { // 객체 생성될 때
        list = new ArrayList<>(); // 리스트 생성
    }
}

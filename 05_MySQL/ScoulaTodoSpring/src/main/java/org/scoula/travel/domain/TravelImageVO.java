package org.scoula.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelImageVO {
    private Long no;
    private Long travelNo;
    private String fileName;
    private String path;
    private long size;

    public static TravelImageVO of(File file) {
        return TravelImageVO.builder()
                .travelNo(Long.parseLong(file.getName().substring(0, 3)))
                .fileName(file.getName())
                .path(file.getPath())
                .size(file.length())
                .build();
    }
}

package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dto.board.BoardDto;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardDto> getList(); // R
    public BoardDto get(Long no); // R
    public int create(BoardDto board); // C
    public int update(BoardDto board); // U
    public int delete(Long no); // D
}

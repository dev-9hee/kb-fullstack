package org.scoula.board.service;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    public List<BoardDTO> getList();

    public BoardDTO get(Long no);

    public BoardDTO create(BoardDTO board); // 생성된 객체를 리턴

    public BoardDTO update(BoardDTO board); // 업데이트된 객체를 리턴

    public BoardDTO delete(Long no); // 삭제된 객체를 리턴

    public BoardAttachmentVO getAttachment(Long no);

    public boolean deleteAttachment(Long no);
}

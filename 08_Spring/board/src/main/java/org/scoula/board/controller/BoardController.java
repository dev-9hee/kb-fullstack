package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Arrays;

@Controller
@Log4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final private BoardService service;

    @GetMapping("/list") // 목록요청
    public void list(Model model) {

        log.info("list");
        model.addAttribute("list", service.getList());
    }

    @GetMapping("/create")
    public void create() {
        log.info("create");
    }

    @PostMapping("/create")
    public String create(BoardDTO board, RedirectAttributes ra) { // 추가 후 목록으로
        log.info("create : " + board);
        service.create(board);
        ra.addAttribute("result", board.getNo());
        return "redirect:/board/list";
    }

//    @PostMapping("/create")
//    public String create(@RequestParam("title") String title,
//                         @RequestParam("writer") String writer,
//                         @RequestParam("content") String content,
//                         @RequestParam("files") MultipartFile[] files) { // 추가 후 목록으로
//        // DTO로 직접 데이터를 세팅해줍니다.
//        BoardDTO board = new BoardDTO();
//        board.setTitle(title);
//        board.setWriter(writer);
//        board.setContent(content);
//
//        // 파일 처리 로직 추가
//        board.setFiles(Arrays.asList(files)); // MultipartFile[]를 List<MultipartFile>로 변환
//
//        service.create(board);
//        return "redirect:/board/list";
//    }

    @GetMapping({ "/get", "/update" }) // 글 상세보기와, 업데이트
    public void get(@RequestParam("no") Long no, Model model) {

        log.info("/get or update");
        model.addAttribute("board", service.get(no));
    }

    @PostMapping("/update")
    public String update(BoardDTO board) {
        log.info("update : " + board);
        service.update(board);
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no) {

        log.info("delete : " + no);
        service.delete(no);

        return "redirect:/board/list";
    }

    @GetMapping("/download/{no}")
    @ResponseBody // view 를 사용하지 않고, 직접 내보냄
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {

        BoardAttachmentVO attach = service.getAttachment(no);

        File file = new File(attach.getPath());

        UploadFiles.download(response, file, attach.getFilename());
    }
}

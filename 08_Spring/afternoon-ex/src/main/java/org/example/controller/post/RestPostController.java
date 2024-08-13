package org.example.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.post.PostDto;
import org.example.dto.post.PostRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController // Controller + ResponseBody 어노테이션 합쳐진 것
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // * : 모든 요청 허용, localhost(127.0.0.1)
@RequestMapping("/post/v1/rest")
public class RestPostController {
    private final PostRepository postRepository;
    private String context = "/post/v1";

    // @ResponseBody
    // 게시글 목록
    @GetMapping("/show")
    public List<PostDto> postList(HttpServletRequest request) {
        log.info("==================> 게시글 목록 페이지 호출, " + request.getRequestURI());

        List<PostDto> list = postRepository.findAll();
        return list;
    }

    @GetMapping("/search")
    public List<PostDto> postSearch(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request
    ) {
        log.info("==================> 게시물 검색 기능 호출, " + request.getRequestURI());

        List<PostDto> searchedList = postRepository.findByCondition(title, content);

        return searchedList;
    }

    // 게시글 추가 페이지 보여주기
    @GetMapping("/new")
    public String postSavePage(HttpServletRequest request) {
        log.info("=================> 게시물 추가 페이지 호출, " + request.getRequestURI());
        return context + "/post-new";
    }

    // 게시글 삭제
    @PostMapping("/delete")
    public String postDelete(
            @RequestParam("id") String id,
            HttpServletRequest request
    ) {
        log.info("================> 게시글 삭제 기능 호출, " + request.getRequestURI());

        long postId = Long.parseLong(id);
        int affectedRows = postRepository.postDelete(postId);

        if (affectedRows > 0) log.info("삭제 성공");

        return "redirect:/post/v1/show";
    }


    // 게시글 추가
    @PostMapping("/new")
    public String postSave(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request
    ) {
        log.info("================> 게시글 추가 기능 호출, " + request.getRequestURI());

        int affectedRows = postRepository.postSave(title, content);

        if (affectedRows > 0) log.info("추가 성공");

        return "redirect:/post/v1/show";
    }
}

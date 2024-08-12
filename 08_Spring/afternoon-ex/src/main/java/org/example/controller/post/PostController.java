package org.example.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.example.dto.post.PostDto;
import org.example.dto.post.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/v1")
public class PostController {
    private final PostRepository postRepository;
    private String context = "/post";

    // 게시글 목록
    @GetMapping("/show")
    public String postList(HttpServletRequest request, Model model) {
        log.info("==================> 게시글 목록 페이지 호출, " + request.getRequestURI());

        model.addAttribute("postList", postRepository.findAll());

        List<PostDto> postDtoList = postRepository.findAll();
        for (PostDto postDto : postDtoList) {
            log.info(postDto.toString());
        }

        return context + "/post-show";
    }

    @GetMapping("/search")
    public String postSearch(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request,
            Model model
    ) {
        log.info("==================> 게시물 검색 기능 호출, " + request.getRequestURI());

        List<PostDto> searchedList = postRepository.findByCondition(title, content);
        model.addAttribute("postList", searchedList);
        return context + "/post-show";
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

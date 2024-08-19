package org.example.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.post.PostDto;
import org.example.dto.post.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController // Controller + ResponseBody 어노테이션 합쳐진 것
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // * : 모든 요청 허용, localhost(127.0.0.1)
@RequestMapping("/post/v2/rest")
public class RestPostControllerV2 {
    private final PostRepository postRepository;
    private String context = "/post/v1";

    // @ResponseBody
    // 게시글 목록
    @GetMapping("/show")
    public ResponseEntity<List<PostDto>> postList(HttpServletRequest request) {
        log.info("==================> 게시글 목록 페이지 호출, " + request.getRequestURI());

        List<PostDto> list = postRepository.findAll();

        return ResponseEntity.ok(list); // ok = 200번
    }

    @GetMapping(value = "/test", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> test() {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("요청을 처리할 수 없습니다");
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
    @DeleteMapping(value = "/delete/{id}", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> postDelete(
            @PathVariable("id") Long id,
            HttpServletRequest request
    ) {
        log.info("================> 게시글 삭제 기능 호출, " + request.getRequestURI());

        int affectedRows = postRepository.postDelete(id);


        if (affectedRows > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("요청을 처리할 수 없습니다");
        }
    }

//    // 게시글 삭제
//    @PostMapping(value = "/delete", produces = "text/plain;charset=UTF-8")
//    public ResponseEntity<String> postDelete(
//            @RequestParam("id") Long id,
//            HttpServletRequest request
//    ) {
//        log.info("================> 게시글 삭제 기능 호출, " + request.getRequestURI());
//
//        int affectedRows = postRepository.postDelete(id);
//
//
//        if (affectedRows > 0) {
//            return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("요청을 처리할 수 없습니다");
//        }
//    }


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

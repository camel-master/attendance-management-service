package org.sarang.attend.web;

import lombok.RequiredArgsConstructor;
import org.sarang.attend.service.posts.PostsService;
import org.sarang.attend.web.dto.PostsResponseDto;
import org.sarang.attend.web.dto.PostsSaveRequestDto;
import org.sarang.attend.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    /**
     * Test 시 restTemplate.postForEntity(url, requestDto, Long.class)의 Lng.class type 처리 중
     * 오류 발생으로 @PutMapping --> @PostMapping으로 변경함.
     */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}

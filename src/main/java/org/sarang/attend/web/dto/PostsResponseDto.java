package org.sarang.attend.web.dto;

import lombok.Getter;
import org.sarang.attend.domain.posts.Posts;

@Getter
public class PostsResponseDto {
    private Long id;
    private String link;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.link = "href=\"/posts/update/" + this.id + "\"";
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}

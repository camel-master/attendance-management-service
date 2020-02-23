package org.sarang.attend.web.dto;

import lombok.Getter;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.sarang.attend.domain.posts.Posts;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Getter
public class PostsResponseDtoTest {
    @Test public void
    canCreatePostsResponseDto() {
        Posts entity = new Posts("test","test","test");
        PostsResponseDto postsResponseDto = new PostsResponseDto(entity);
        assertThat(postsResponseDto.getLink(), is("href=\"/posts/update/null\""));
    }
}

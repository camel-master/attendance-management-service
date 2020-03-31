package org.sarang.attend.web.dto;

import lombok.Getter;
import org.sarang.attend.domain.user.Role;
import org.sarang.attend.domain.user.User;

import java.time.LocalDateTime;

@Getter
public class RolesListResponseDto {
    private Long id;
    private String name;
    private String picture;
    private Role role;
    private LocalDateTime modifiedDate;

    public RolesListResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.picture = entity.getPicture();
        this.role = entity.getRole();
        this.modifiedDate = entity.getModifiedDate();
    }
}

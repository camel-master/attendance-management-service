package org.sarang.attend.service.posts;

import lombok.RequiredArgsConstructor;
import org.sarang.attend.domain.posts.PostsRepository;
import org.sarang.attend.domain.user.User;
import org.sarang.attend.domain.user.UserRepository;
import org.sarang.attend.web.dto.PostsListResponseDto;
import org.sarang.attend.web.dto.RolesListResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RolesService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<RolesListResponseDto> findAllDesc() {
        return userRepository.findAllDesc().stream()
                .map(RolesListResponseDto::new)
                .collect(Collectors.toList());
    }
}

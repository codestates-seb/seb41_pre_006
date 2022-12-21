package pre006.stackoverflow.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.user.dto.UserPostDto;
import pre006.stackoverflow.domain.user.dto.UserResponseDto;
import pre006.stackoverflow.domain.user.entity.User;
import pre006.stackoverflow.domain.user.mapper.UserMapper;
import pre006.stackoverflow.domain.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponseDto post(@RequestBody UserPostDto userPostDto) {
        User user = mapper.userPostDtoToEntity(userPostDto);
        User addUser = service.add(user);
        UserResponseDto userResponseDto = mapper.userToResponseDto(addUser);

        return userResponseDto;
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<User> users = service.getUsers();
        return users.stream().map(user -> mapper.userToResponseDto(user))
                .collect(Collectors.toList());
    }
}

package pre006.stackoverflow.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.user.dto.UserPatchDto;
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

    private final UserService userService;
    private final UserMapper mapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponseDto post(@RequestBody @Validated UserPostDto userPostDto) {
        User user = mapper.userPostDtoToEntity(userPostDto);
        User addUser = userService.add(user);
        UserResponseDto userResponseDto = mapper.userToResponseDto(addUser);

        return userResponseDto;
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<User> users = userService.getUsers();
        return users.stream().map(user -> mapper.userToResponseDto(user))
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserResponseDto getOne(@PathVariable Long userId) {
        return mapper.userToResponseDto(userService.findById(userId));
    }

    @PatchMapping("/{userId}")
    public UserResponseDto patchOne(@PathVariable Long userId,
            @RequestBody @Validated UserPatchDto userPatchDto) {
        User modifyUser = userService.modifyUser(userId, mapper.userPatchDtoToEntity(userPatchDto));
        return mapper.userToResponseDto(modifyUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

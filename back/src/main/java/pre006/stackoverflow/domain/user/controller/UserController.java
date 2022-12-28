package pre006.stackoverflow.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    // @GetMapping
    // public List<UserResponseDto> getAll() {
    //     List<User> users = userService.getUsers();
    //     return users.stream().map(user -> mapper.userToResponseDto(user))
    //             .collect(Collectors.toList());
    // }

    @GetMapping()
    public List<UserResponseDto> getAll(@RequestParam(defaultValue = "-1") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "new") String sort) {
        log.info("page,info={}{}", page, size);
        List<User> users;

        if (page > 0 && size > 0) {
            Page<User> pageUser = userService.getUsers(
                    PageRequest.of(page - 1, size, Sort.by("createdAt").descending()));
            users = pageUser.getContent();

        } else { users = userService.getAll(); }

        return mapper.userListToResponseDto(users);
    }


    @GetMapping("/{userId}")
    public UserResponseDto getOne(@PathVariable Long userId) {
        return mapper.userToResponseDto(userService.findById(userId));
    }

    @PatchMapping("/{userId}")
    public UserResponseDto patchOne(@PathVariable Long userId, @RequestBody @Validated UserPatchDto userPatchDto) {
        User modifyUser = userService.modifyUser(userId, mapper.userPatchDtoToEntity(userPatchDto));
        return mapper.userToResponseDto(modifyUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

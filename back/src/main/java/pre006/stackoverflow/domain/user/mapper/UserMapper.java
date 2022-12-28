package pre006.stackoverflow.domain.user.mapper;

import org.mapstruct.Mapper;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.user.dto.QResponseDto;
import pre006.stackoverflow.domain.user.dto.UserPatchDto;
import pre006.stackoverflow.domain.user.dto.UserPostDto;
import pre006.stackoverflow.domain.user.dto.UserResponseDto;
import pre006.stackoverflow.domain.user.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userPostDtoToEntity(UserPostDto userPostDto);

    UserResponseDto userToResponseDto(User user);

    User userPatchDtoToEntity(UserPatchDto userPatchDto);

    QResponseDto questionToResponseDto(Question questions);

    List<UserResponseDto> userListToResponseDto(List<User> users);
}

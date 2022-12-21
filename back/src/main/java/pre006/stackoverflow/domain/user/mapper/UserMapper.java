package pre006.stackoverflow.domain.user.mapper;

import org.mapstruct.Mapper;
import pre006.stackoverflow.domain.user.dto.UserPostDto;
import pre006.stackoverflow.domain.user.dto.UserResponseDto;
import pre006.stackoverflow.domain.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userPostDtoToEntity(UserPostDto userPostDto);

    UserResponseDto userToResponseDto(User user);
}

package pre006.stackoverflow.domain.user.dto;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long userId;
    private String email;
    private String name;
    private String description;
    private String location;
}

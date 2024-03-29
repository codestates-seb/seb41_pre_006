package pre006.stackoverflow.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserPostDto {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private String description;

    private String location;
}

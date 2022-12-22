package pre006.stackoverflow.domain.user.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserPatchDto {

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

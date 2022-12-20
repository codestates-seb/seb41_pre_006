package pre006.stackoverflow.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    private Long id;
    private String email;
    private String password;
    private String name;
    private String content;
    private String location;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;
}

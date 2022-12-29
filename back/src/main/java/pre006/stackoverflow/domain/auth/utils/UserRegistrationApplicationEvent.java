package pre006.stackoverflow.domain.auth.utils;

import lombok.Getter;
import pre006.stackoverflow.domain.user.entity.User;

@Getter
public class UserRegistrationApplicationEvent {

    private User user;

    public UserRegistrationApplicationEvent(User user) {
        this.user = user;
    }
}

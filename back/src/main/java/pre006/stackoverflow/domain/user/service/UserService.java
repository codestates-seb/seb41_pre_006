package pre006.stackoverflow.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pre006.stackoverflow.domain.user.entity.User;
import pre006.stackoverflow.domain.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User add(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}

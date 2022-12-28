package pre006.stackoverflow.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre006.stackoverflow.domain.user.entity.User;
import pre006.stackoverflow.domain.user.repository.UserRepository;
import pre006.stackoverflow.global.customException.DuplicatedEmailException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User add(User user) {
        verifyExistEmail(user.getEmail());
        return repository.save(user);
    }

    public Page<User> getUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    /**
     * userId로 검색된 유저가 없으면 NoSuchElementException 발생
     */
    public User findById(Long userId) {
        Optional<User> findUser = repository.findById(userId);
        return findUser.orElseThrow(() -> new NoSuchElementException("No Such User"));
    }

    public User modifyUser(Long userId, User user) {
        User findUser = findById(userId);
        verifyExistEmail(user.getEmail());
        updateUserInfo(user, findUser);
        return findUser;
    }

    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }

    private void updateUserInfo(User user, User findUser) {
        findUser.setEmail(user.getEmail());
        findUser.setPassword(user.getPassword());
        findUser.setName(user.getName());
        findUser.setDescription(user.getDescription());
        findUser.setLocation(user.getLocation());
    }

    private void verifyExistEmail(String email) {
        Optional<User> findUserByEmail = repository.findByEmail(email);
        if (findUserByEmail.isPresent()) {
            throw new DuplicatedEmailException("이미 존재하는 이메일 입니다.");
        }
    }

}

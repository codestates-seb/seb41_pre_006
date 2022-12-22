package pre006.stackoverflow.domain.user.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pre006.stackoverflow.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class UserRepositoryTest {

    private final UserRepository repository;

    @Autowired
    public UserRepositoryTest(UserRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    void beforeEach() {
        User userA = addUser("hgd1@naver.com", "1111", "김코딩", "김코딩 입니다.", "서울");
        User userB = addUser("hgd2@naver.com", "2222", "나해커", "나해커 입니다.", "부산");
        User userC = addUser("hgd3@naver.com", "3333", "박사장", "박사장 입니다.", "대구");
    }


    @Test
    @DisplayName("저장, 조회")
    void saveAndFind() {
        User saveUser = addUser("hgd4@naver.com", "4444", "하이요", "하이요 입니다.", "뉴욕");

        User findUser = repository.findById(saveUser.getUserId()).get();

        assertThat(findUser).isEqualTo(saveUser);
    }

    @Test
    void findUsers() {
        List<User> allUsers = repository.findAll();
        assertThat(allUsers).containsExactly();
    }

    @Test
    void hi() {
        System.out.println("hello");
    }

    private User addUser(String email, String password, String name, String description, String location) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setDescription(description);
        user.setLocation(location);
        user.setCreatedAt(LocalDateTime.now());
        user.setModifiedAt(LocalDateTime.now());
        return repository.save(user);
    }
}
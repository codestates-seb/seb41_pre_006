package pre006.stackoverflow.domain.question.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pre006.stackoverflow.domain.question.entity.Question;

import java.util.NoSuchElementException;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class questionRepositoryTest {

    @Autowired
    private QuestionRepository repository;

    @BeforeEach
    void beforeEach() {
        Question questionA = addQue("ASDAF", "ADSGSDAGASDG" ,"0", "0");
        Question questionB = addQue("ASDAF", "ADSGSDAGASDG" ,"0", "0");
}


    @Test
    @DisplayName("저장과 조회")
    void saveAndFind() {
        Question saveQuestion = addQue("125125", "ㅁㅇㄶㅈㅁㄷㅅㅎㅊㅌ큐", "0", "0");

        Question findQuestion = repository.findById(saveQuestion.getQuestionId()).get();

        assertThat(findQuestion).isEqualTo(saveQuestion);
    }



    private Question addQue(String title, String content, String viewCount, String voteCount) {
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setViewCount(Long.valueOf(viewCount));
        question.setVoteCount(Long.valueOf(voteCount));
        return repository.save(question);
    }
    }

package pre006.stackoverflow.domain.user.entity;

import lombok.Data;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.entity.Question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "USER")
public class User extends BaseTime {
    @Id
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "user")
    private List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Answer> answerList = new ArrayList<>();

    public void addQuestionList(Question question) {
        this.questionList.add(question);
    }

    public void addAnswerList(Answer answer) {
        this.answerList.add(answer);
    }

}

package pre006.stackoverflow.domain.user.entity;

import lombok.Data;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.comment.entity.Comment;
import pre006.stackoverflow.domain.question.entity.Question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "USERS")
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;

    //JWT 적용
    @ElementCollection(fetch = FetchType.EAGER)//
    private List<String> roles = new ArrayList<>();
    //JWT 적용 완료

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Answer> answerList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    public void addQuestionList(Question question) {
        this.questionList.add(question);
        if (question.getUser() != this) {
            question.setUser(this);
        }
    }

    public void addAnswerList(Answer answer) {
        this.answerList.add(answer);
        if (answer.getUser() != this) {
            answer.setUser(this);
        }
    }

}

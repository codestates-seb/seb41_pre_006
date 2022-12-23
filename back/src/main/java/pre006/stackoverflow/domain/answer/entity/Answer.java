package pre006.stackoverflow.domain.answer.entity;

import lombok.Data;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.user.entity.User;

import javax.persistence.*;

@Data
@Entity(name = "ANSWER")
public class Answer extends BaseTime {

    @Id
    @GeneratedValue
    private Long answerId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}

package pre006.stackoverflow.domain.comment.entity;


import lombok.Data;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.user.entity.User;


import javax.persistence.*;

@Entity
@Data
public class Comment extends BaseTime {

    @Id
    @GeneratedValue
    private long commentId;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;
}

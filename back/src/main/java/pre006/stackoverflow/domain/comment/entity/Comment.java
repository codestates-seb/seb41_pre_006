package pre006.stackoverflow.domain.comment.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.user.entity.User;


import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Comment extends BaseTime {

    @Id
    @GeneratedValue
    private long commentId;

    @Column(nullable = false)
    private String content;

    @JsonBackReference // user entity 추가 필요
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference // question entity 추가 필요
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;
}

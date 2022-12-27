package pre006.stackoverflow.domain.answer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.comment.entity.Comment;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "ANSWER")
public class Answer extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private Long voteCount = 0L;

    @ElementCollection
    private List<Long> upvoteUserId = new ArrayList<>();

    @ElementCollection
    private List<Long> downvoteUserId = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @JsonManagedReference
    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();
}

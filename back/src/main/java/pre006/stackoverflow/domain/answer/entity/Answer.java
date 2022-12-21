package pre006.stackoverflow.domain.answer.entity;

import lombok.Data;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.user.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity(name = "ANSWER")
public class Answer extends BaseTime {

    @Id
    private Long answerId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    private User user;

}
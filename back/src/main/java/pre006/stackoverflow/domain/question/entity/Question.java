package pre006.stackoverflow.domain.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.user.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "QUESTION")
public class Question extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private Long viewCount;

    @ManyToOne
    private User user;

}

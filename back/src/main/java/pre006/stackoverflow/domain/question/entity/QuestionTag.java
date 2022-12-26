package pre006.stackoverflow.domain.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.dto.QuestionDto;
import pre006.stackoverflow.domain.question.mapper.QuestionVoteMapper;
import pre006.stackoverflow.domain.question.repository.QuestionVoteRepository;
import pre006.stackoverflow.domain.tag.entity.Tag;
import pre006.stackoverflow.domain.question.entity.Question;
import javax.persistence.*;
import java.util.Optional;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class QuestionTag extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTagId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public void addQuestion(Question question) {
        this.question = question;
    }

    public void addTag(Tag tag) {
        this.tag = tag;
    }

}

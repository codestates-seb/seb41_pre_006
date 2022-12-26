package pre006.stackoverflow.domain.question.dto;

import lombok.*;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.entity.QuestionTag;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;
import pre006.stackoverflow.domain.tag.entity.Tag;
import pre006.stackoverflow.domain.tag.repository.TagRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
public class QuestionTagDto {

    private Long questionTagId;
    private Question question;
    private Tag tag;

    public QuestionTagDto(QuestionTag questionTag) {
        this.questionTagId = questionTag.getQuestionTagId();
        this.question = questionTag.getQuestion();
        this.tag = questionTag.getTag();
    }

    public QuestionTagDto(Long questionTagId, Question question, Tag tag) {
        this.questionTagId = questionTagId;
        this.question = question;
        this.tag = tag;
    }

}

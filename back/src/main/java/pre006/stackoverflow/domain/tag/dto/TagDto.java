package pre006.stackoverflow.domain.tag.dto;

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
public class TagDto {

        private Long tagId;
        private String tagName;
        private List<QuestionTag> questionTag = new ArrayList<>();

        public TagDto(Tag tag) {
            this.tagId = tag.getTagId();
            this.tagName = tag.getTagName();
            this.questionTag = tag.getQuestionTag();
        }

        public TagDto(Long tagId, String tagName, List<QuestionTag> questionTag) {
            this.tagId = tagId;
            this.tagName = tagName;
            this.questionTag = questionTag;
        }
}

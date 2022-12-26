package pre006.stackoverflow.domain.tag.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.entity.QuestionTag;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;
import pre006.stackoverflow.domain.tag.dto.TagDto;
import pre006.stackoverflow.domain.tag.repository.TagRepository;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(nullable = false)
    private String tagName;

    @OneToMany(mappedBy = "tag")
    private List<QuestionTag> questionTag = new ArrayList<>();



    public void addQuestionTag(QuestionTag questionTag) {
        this.questionTag.add(questionTag);
    }


}

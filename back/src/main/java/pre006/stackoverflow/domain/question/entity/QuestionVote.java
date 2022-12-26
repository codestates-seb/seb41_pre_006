package pre006.stackoverflow.domain.question.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre006.stackoverflow.domain.audit.BaseTime;

import javax.persistence.*;
import java.util.Optional;

//엔티티그래프 오류
//@NamedEntityGraph(name = "Question.withQuestionVote", attributeNodes = {
//        @NamedAttributeNode("QuestionVote") // QuestionVote를 EAGER로 가져옴
//})

@Getter
@Setter
@Entity
@NoArgsConstructor
public class QuestionVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionVoteId;

    @Column(nullable = false)
    private int vote = 0;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public void addQuestion(Question question) {
        this.question = question;
        if (this.question == null && question != null)
            question.addQuestionVote(this);
    }

}

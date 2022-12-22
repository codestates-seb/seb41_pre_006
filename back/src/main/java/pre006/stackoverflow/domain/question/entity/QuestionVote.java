//package pre006.stackoverflow.domain.question.entity;
//
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import pre006.stackoverflow.domain.audit.BaseTime;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@NamedEntityGraph(name = "Question.withQuestionVote", attributeNodes = {
//        @NamedAttributeNode("QuestionVote") // QuestionVote를 가져온다.
//
//})
//@Getter
//@Setter
//@Entity
//@NoArgsConstructor
//public class QuestionVote extends BaseTime {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long questionId;
//
//    @Column(nullable = false)
//    private int voteCount;
//
//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Question question;
//
//    public void addQuestion(Question question) {
//        this.question = question;
//        if (this.question == null && question != null)
//            this.question = question;
//    }
//
//}

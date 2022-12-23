package pre006.stackoverflow.domain.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.user.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@NoArgsConstructor
@Getter
@Setter
@Entity(name = "QUESTION")
public class Question extends BaseTime {

    @Id     // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private Long viewCount;

    @Column(nullable = false)
    private Long voteCount;



    @OneToMany(mappedBy = "question")
    List<QuestionVote> questionVote = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    List<Answer> answerList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Question과 User는 다대일 관계


    public void addQuestionVote(QuestionVote questionVote) {
        this.questionVote.add(questionVote);
        if (questionVote.getQuestion() != this)
            questionVote.setQuestion(this);
    }

    public void addUser(User user) {
        this.user = user;
        if (this.user == null && user != null)
            this.user = user;
    }

    public void addAnswerList(Answer answer) {
        this.answerList.add(answer);
    }

//    public void addQuestionVoteList(QuestionVote questionVote) {
//        this.questionVote.add(questionVote);
//    }


}

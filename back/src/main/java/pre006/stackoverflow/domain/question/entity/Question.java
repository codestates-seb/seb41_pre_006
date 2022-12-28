package pre006.stackoverflow.domain.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.comment.entity.Comment;
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
    private Long viewCount = 0L;

    @Column(nullable = false)
    private Long voteCount = 0L;

    @ElementCollection
    private List<Long> upvoteUserId = new ArrayList<>();

    @ElementCollection
    private List<Long> downvoteUserId = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<QuestionTag> questionTag = new ArrayList<>();


    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    List<Answer> answerList = new ArrayList<>();

    public void addViewCount() {
        this.viewCount++;
    }

    public void addAnswerList(Answer answer) {
        this.answerList.add(answer);
    }



    // @OneToMany(mappedBy = "question")
    // List<QuestionVote> questionVote = new ArrayList<>();

//    public void addQuestionVoteList(QuestionVote questionVote) {
//        this.questionVote.add(questionVote);
//    }


}

package pre006.stackoverflow.domain.comment.dto;

import javax.validation.constraints.NotEmpty;

public class CommentPostDto {

    private long commentId;
    @NotEmpty
    private String content;
    private long answerId;
    private long questionId;

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}

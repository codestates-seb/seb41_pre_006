package pre006.stackoverflow.domain.comment.dto;

import javax.validation.constraints.NotEmpty;

public class CommentPostDto {

    private long commentId;
    @NotEmpty
    private String content;

    public void PostAnswerComment(String content) {
        this.content = content;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }


}

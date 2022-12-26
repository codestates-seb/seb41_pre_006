package pre006.stackoverflow.domain.comment.dto;

import javax.validation.constraints.NotEmpty;

public class CommentPatchDto {
    private long commentId;
    @NotEmpty
    private String body;

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }
}

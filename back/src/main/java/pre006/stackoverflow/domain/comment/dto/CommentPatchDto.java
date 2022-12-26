package pre006.stackoverflow.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class CommentPatchDto {
    private long commentId;
    @NotEmpty
    private String body;

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }
}

package pre006.stackoverflow.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class CommentPatchDto {
    private Long commentId;
    @NotEmpty
    private String content;

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}

package pre006.stackoverflow.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class CommentPostDto {

    private long commentId;

    @NotEmpty
    private String content;

    private long answerId;

    private long questionId;
}

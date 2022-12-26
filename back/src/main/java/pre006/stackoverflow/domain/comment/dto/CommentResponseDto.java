package pre006.stackoverflow.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pre006.stackoverflow.domain.audit.BaseTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto extends BaseTime {

    private long commentId;
    private String content;

}

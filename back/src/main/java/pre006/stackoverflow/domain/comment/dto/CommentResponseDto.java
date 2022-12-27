package pre006.stackoverflow.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pre006.stackoverflow.domain.audit.BaseTime;

@Getter
@Setter
@AllArgsConstructor
public class CommentResponseDto extends BaseTime {

    private Long commentId;
    private Long userId;
    private String userName;
    private String content;

}

package pre006.stackoverflow.domain.question.dto;

import lombok.Getter;
import lombok.Setter;
import pre006.stackoverflow.domain.comment.dto.CommentResponseDto;

import java.util.List;

@Getter
@Setter
public class AResponseDto {

    private Long answerId;
    private String content;
    private Long userId;
    private String userName;
    private Long voteCount;
    private List<CommentResponseDto> comments;
}

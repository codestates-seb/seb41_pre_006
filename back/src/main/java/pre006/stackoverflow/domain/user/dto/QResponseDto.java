package pre006.stackoverflow.domain.user.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QResponseDto {
    private Long questionId;
    private String title;
    private String content;
    private Long viewCount;
    private Long voteCount;
}

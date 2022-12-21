package pre006.stackoverflow.domain.answer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerPatchDto {
    private long answerId;
    private String content;
}

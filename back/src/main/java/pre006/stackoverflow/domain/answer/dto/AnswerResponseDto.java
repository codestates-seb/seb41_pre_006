package pre006.stackoverflow.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pre006.stackoverflow.domain.audit.BaseTime;

@Getter
@AllArgsConstructor
public class AnswerResponseDto extends BaseTime {
    private Long answerId;
    private String content;
    private Long questionId;

}

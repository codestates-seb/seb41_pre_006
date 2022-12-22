package pre006.stackoverflow.domain.answer.dto;

import lombok.Getter;
import lombok.Setter;
import pre006.stackoverflow.domain.audit.BaseTime;

@Getter
@Setter
public class AnswerResponseDto extends BaseTime {
    private long answerId;
    private String content;
    private long questionId;

    public AnswerResponseDto(long answerId, String content, long questionId){
        this.answerId = answerId;
        this.content = content;
        this.questionId = questionId;
    }
}

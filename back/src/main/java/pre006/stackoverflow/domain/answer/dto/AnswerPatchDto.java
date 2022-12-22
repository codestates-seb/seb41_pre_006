package pre006.stackoverflow.domain.answer.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AnswerPatchDto {
    private long answerId;
    @NotEmpty
    private String content;
    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}

package pre006.stackoverflow.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class AnswerPatchDto {
    private long answerId;
    @NotEmpty
    private String content;
    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}

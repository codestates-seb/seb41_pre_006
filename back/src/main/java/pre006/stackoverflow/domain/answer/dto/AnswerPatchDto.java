package pre006.stackoverflow.domain.answer.dto;

import javax.validation.constraints.NotEmpty;

public class AnswerPatchDto {
    private long answerId;
    @NotEmpty
    private String content;
    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}

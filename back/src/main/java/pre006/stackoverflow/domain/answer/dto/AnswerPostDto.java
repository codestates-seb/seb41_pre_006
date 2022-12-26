package pre006.stackoverflow.domain.answer.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class AnswerPostDto {

    private long questionId;
    @NotEmpty
    private String content;

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

}

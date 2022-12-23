package pre006.stackoverflow.domain.answer.dto;

import javax.validation.constraints.NotEmpty;

public class AnswerPostDto {
    @NotEmpty
    private String content;

}

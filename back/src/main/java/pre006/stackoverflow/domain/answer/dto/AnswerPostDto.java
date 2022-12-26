package pre006.stackoverflow.domain.answer.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class AnswerPostDto {
    @NotEmpty
    private String content;

}

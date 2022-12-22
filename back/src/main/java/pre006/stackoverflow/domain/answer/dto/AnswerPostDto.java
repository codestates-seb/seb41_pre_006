package pre006.stackoverflow.domain.answer.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AnswerPostDto {
    @NotEmpty
    private String content;
}

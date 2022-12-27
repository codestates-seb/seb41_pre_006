package pre006.stackoverflow.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class AnswerPostDto {

    @NotEmpty
    private String content;

}

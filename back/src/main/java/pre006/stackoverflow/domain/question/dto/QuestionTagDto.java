package pre006.stackoverflow.domain.question.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class QuestionTagDto {
    @Positive
    private Long tagId;
}

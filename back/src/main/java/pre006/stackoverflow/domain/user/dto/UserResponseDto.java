package pre006.stackoverflow.domain.user.dto;

import lombok.Data;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.question.entity.Question;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponseDto {

    private Long userId;
    private String email;
    private String name;
    private String description;
    private String location;
    private List<Question> questionList = new ArrayList<>();
    private List<Answer> answerList = new ArrayList<>();

}

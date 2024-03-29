package pre006.stackoverflow.domain.user.dto;

import lombok.Data;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.question.entity.Question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponseDto {

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long userId;
    private String email;
    private String name;
    private String description;
    private String location;
    private List<QResponseDto> questionList = new ArrayList<>();
    // private List<Answer> answerList = new ArrayList<>();

}

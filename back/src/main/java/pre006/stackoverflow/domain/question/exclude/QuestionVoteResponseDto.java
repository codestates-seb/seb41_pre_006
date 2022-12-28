package pre006.stackoverflow.domain.question.exclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre006.stackoverflow.domain.question.entity.Question;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionVoteResponseDto {
    private long questionId;
    private long vote;
    private long totalVote;


}


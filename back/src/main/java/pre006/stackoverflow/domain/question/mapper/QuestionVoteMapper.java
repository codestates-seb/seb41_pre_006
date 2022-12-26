package pre006.stackoverflow.domain.question.mapper;

import org.mapstruct.Mapper;
import pre006.stackoverflow.domain.question.dto.QuestionVoteResponseDto;
import pre006.stackoverflow.domain.question.entity.QuestionVote;

@Mapper(componentModel = "spring")
public class QuestionVoteMapper {

    public QuestionVoteResponseDto questionVoteToQuestionVoteDto(QuestionVote questionVote) {
        QuestionVoteResponseDto questionVoteDto = new QuestionVoteResponseDto();
        questionVoteDto.setQuestionId(questionVote.getQuestion().getQuestionId());
//        questionVoteDto.setVote(questionVote.getVote());
//        questionVoteDto.setTotalVote(questionVote.getQuestion().getVoteCount());

        return questionVoteDto;
    }
}

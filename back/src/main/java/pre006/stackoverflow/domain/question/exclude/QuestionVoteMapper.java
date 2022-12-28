package pre006.stackoverflow.domain.question.exclude;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class QuestionVoteMapper {

    public QuestionVoteResponseDto questionVoteToQuestionVoteDto(QuestionVote questionVote) {
        QuestionVoteResponseDto questionVoteDto = new QuestionVoteResponseDto();
        questionVoteDto.setQuestionId(questionVote.getQuestion().getQuestionId());
        questionVoteDto.setVote(questionVote.getVote());
        questionVoteDto.setTotalVote(questionVote.getQuestion().getVoteCount());

        return questionVoteDto;
    }
}

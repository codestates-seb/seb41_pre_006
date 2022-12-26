package pre006.stackoverflow.domain.answer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pre006.stackoverflow.domain.answer.dto.AnswerPatchDto;
import pre006.stackoverflow.domain.answer.dto.AnswerPostDto;
import pre006.stackoverflow.domain.answer.dto.AnswerResponseDto;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.question.entity.Question;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    default Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto, long questionId) {
        Answer answer = new Answer();
        answer.setContent(answerPostDto.getContent());
        Question question = new Question();
        question.setQuestionId(questionId);
        answer.setQuestion(question);

        return answer;
    }
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    @Mapping(source = "question.questionId", target = "questionId")
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);

}

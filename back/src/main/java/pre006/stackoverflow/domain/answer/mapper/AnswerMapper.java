package pre006.stackoverflow.domain.answer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pre006.stackoverflow.domain.answer.dto.AnswerPatchDto;
import pre006.stackoverflow.domain.answer.dto.AnswerPostDto;
import pre006.stackoverflow.domain.answer.dto.AnswerResponseDto;
import pre006.stackoverflow.domain.answer.entity.Answer;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);


}

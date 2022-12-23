package pre006.stackoverflow.domain.question.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pre006.stackoverflow.domain.question.dto.QuestionDto;
import pre006.stackoverflow.domain.question.entity.Question;

@Mapper
public interface QuestionMapper {

        QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

        QuestionDto questionToQuestionDto(Question question);

        Question questionDtoToQuestion(QuestionDto questionDto);
}

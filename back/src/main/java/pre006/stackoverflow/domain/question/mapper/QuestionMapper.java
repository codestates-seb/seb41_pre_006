package pre006.stackoverflow.domain.question.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pre006.stackoverflow.domain.question.dto.QuestionDto;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.user.entity.User;
import pre006.stackoverflow.domain.user.mapper.UserMapper;
import pre006.stackoverflow.domain.user.service.UserService;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

        default Question questionPostDtoToEntity(QuestionDto.QuestionPostDto questionPostDto) {

                Question question = new Question();
                question.setTitle(questionPostDto.getTitle());
                question.setContent(questionPostDto.getContent());

                return question;
        }

        default Question questionPatchDtoToEntity(QuestionDto.QuestionPatchDto questionPatchDto) {

                Question question = new Question();
                question.setQuestionId(questionPatchDto.getQuestionId());
                question.setTitle(questionPatchDto.getTitle());
                question.setContent(questionPatchDto.getContent());
                return question;
        }


        default QuestionDto.QuestionResponseDto entityToQuestionResponseDto(UserMapper userMapper, Question question) {

                QuestionDto.QuestionResponseDto questionResponseDto = new QuestionDto.QuestionResponseDto();
                questionResponseDto.setQuestionId(question.getQuestionId());
                questionResponseDto.setTitle(question.getTitle());
                questionResponseDto.setContent(question.getContent());
                questionResponseDto.setViewCount(question.getViewCount());
                questionResponseDto.setVote(question.getVoteCount());
//                questionResponseDto.setAnswerCount((long) question.getAnswerList().size());
                User user = question.getUser();


                System.out.println("유저: " + user);
                System.out.println("유저맵퍼: " + userMapper);
                questionResponseDto.setUser(userMapper.userToResponseDto(user));



                return questionResponseDto;
        }
}

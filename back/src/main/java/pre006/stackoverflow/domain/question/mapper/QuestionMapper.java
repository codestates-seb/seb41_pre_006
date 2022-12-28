package pre006.stackoverflow.domain.question.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.comment.dto.CommentResponseDto;
import pre006.stackoverflow.domain.comment.entity.Comment;
import pre006.stackoverflow.domain.question.dto.AResponseDto;
import pre006.stackoverflow.domain.question.dto.QuestionDto;
import pre006.stackoverflow.domain.question.dto.QuestionTagDto;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.entity.QuestionTag;
import pre006.stackoverflow.domain.tag.entity.Tag;
import pre006.stackoverflow.domain.user.entity.User;
import pre006.stackoverflow.domain.user.mapper.UserMapper;
import pre006.stackoverflow.domain.user.service.UserService;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

        default Question questionPostDtoToEntity(QuestionDto.QuestionPostDto questionPostDto) {

                Question question = new Question();
                // User 새로 생성해서 userId 저장
                User user = new User();
                user.setUserId(questionPostDto.getUserId());
                question.setUser(user);

                Tag tag = new Tag();
                QuestionTag questionTag = new QuestionTag();
                questionTag.addTag(tag);


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

        @Mapping(source = "user.userId", target = "userId")
        @Mapping(source = "user.name", target = "userName")
        QuestionDto.QuestionResponseDto entityToQuestionResponseDto(Question question);

        @Mapping(source = "user.userId", target = "userId")
        @Mapping(source = "user.name", target = "userName")
        AResponseDto AnswerToResponseDto(Answer answer);

        @Mapping(source = "user.userId", target = "userId")
        @Mapping(source = "user.name", target = "userName")
        CommentResponseDto commentToCommentResponseDto(Comment comment);


        // default QuestionDto.QuestionResponseDto entityToQuestionResponseDto(UserMapper userMapper, Question question) {
        //
        //         QuestionDto.QuestionResponseDto questionResponseDto = new QuestionDto.QuestionResponseDto();
        //         questionResponseDto.setQuestionId(question.getQuestionId());
        //         questionResponseDto.setTitle(question.getTitle());
        //         questionResponseDto.setContent(question.getContent());
        //         questionResponseDto.setViewCount(question.getViewCount());
        //         questionResponseDto.setVote(question.getVoteCount());
//                questionResponseDto.setAnswerCount((long) question.getAnswerList().size());
//                 User user = question.getUser();
//
//
//                 System.out.println("유저: " + user);
//                 System.out.println("유저맵퍼: " + userMapper);
//                 questionResponseDto.setUser(userMapper.userToResponseDto(user));
//
//
//
//                 return questionResponseDto;
//         }
}

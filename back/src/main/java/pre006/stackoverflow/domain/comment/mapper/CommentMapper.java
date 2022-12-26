package pre006.stackoverflow.domain.comment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.comment.dto.CommentPatchDto;
import pre006.stackoverflow.domain.comment.dto.CommentPostDto;
import pre006.stackoverflow.domain.comment.dto.CommentResponseDto;
import pre006.stackoverflow.domain.comment.entity.Comment;
import pre006.stackoverflow.domain.comment.entity.CommentType;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.user.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    default Comment QcommentPostDtoToComment(CommentPostDto commentPostDto, long userId, long questionId) {
        Comment comment = new Comment();
        comment.setContent(comment.getContent());
        User user = new User();
        user.setUserId(userId);
        Question question = new Question();
        question.setQuestionId(questionId);
        comment.setCommentType(CommentType.QUESTION);
        comment.setUser(user);
        comment.setQuestion(question);

        return comment;
    }

    default Comment AcommentPostDtoToComment(CommentPostDto commentPostDto, long userId, long answerId) {
        Comment comment = new Comment();
        comment.setContent(commentPostDto.getContent());
        User user = new User();
        user.setUserId(userId);
        Answer answer = new Answer();
        answer.setAnswerId(answerId);
        comment.setCommentType(CommentType.ANSWER);
        comment.setUser(user);
        comment.setAnswer(answer);

        return comment;
    }

    Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto);

    CommentResponseDto commentToCommentResponseDto(Comment comment);
}

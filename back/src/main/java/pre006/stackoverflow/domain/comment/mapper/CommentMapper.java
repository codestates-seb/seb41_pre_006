package pre006.stackoverflow.domain.comment.mapper;

import org.mapstruct.Mapper;
import pre006.stackoverflow.domain.comment.dto.CommentPatchDto;
import pre006.stackoverflow.domain.comment.dto.CommentPostDto;
import pre006.stackoverflow.domain.comment.dto.CommentResponseDto;
import pre006.stackoverflow.domain.comment.entity.Comment;

@Mapper
public interface CommentMapper {

    Comment commentPostDtoToComment(CommentPostDto commentPostDto);

    Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto);

    CommentResponseDto commentToCommentResponseDto(Comment comment);
}

package pre006.stackoverflow.domain.comment.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.comment.dto.CommentPatchDto;
import pre006.stackoverflow.domain.comment.dto.CommentPostDto;
import pre006.stackoverflow.domain.comment.entity.Comment;
import pre006.stackoverflow.domain.comment.mapper.CommentMapper;
import pre006.stackoverflow.domain.comment.service.CommentService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Slf4j
@Validated
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentController (CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @PostMapping("/question/{userId}/{questionId}") // 질문에 대한 코멘트 추가
    public ResponseEntity postQuestionComment(@PathVariable("userId") Long userId,
            @PathVariable("questionId") Long questionId, @Valid @RequestBody CommentPostDto commentPostDto) {
        Comment comment = commentService.createQuestionComment(commentMapper.QcommentPostDtoToComment(commentPostDto, userId, questionId));

        return new ResponseEntity<>(commentMapper.commentToCommentResponseDto(comment), HttpStatus.CREATED);

    }

    @PostMapping("/answer/{userId}/{answerId}") // 답변에 대한 코멘트 추가
    public ResponseEntity postAnswerComment(@PathVariable ("userId") Long userId,
            @PathVariable("answerId") Long answerId , @Valid @RequestBody CommentPostDto commentPostDto) {
        Comment comment = commentService.createAnswerComment(commentMapper.AcommentPostDtoToComment(commentPostDto, userId, answerId));

        return new ResponseEntity<>(commentMapper.commentToCommentResponseDto(comment), HttpStatus.CREATED);


    }
    @PatchMapping("/{commentId}") // 코멘트 내용 변경
    public ResponseEntity patchComment(@Valid @RequestBody CommentPatchDto commentPatchDto,
                                       @PathVariable("commentId") Long commentId) {
        commentPatchDto.setCommentId(commentId);
        Comment comment = commentService.updateComment(commentMapper.commentPatchDtoToComment(commentPatchDto));


        return new ResponseEntity<>(commentMapper.commentToCommentResponseDto(comment), HttpStatus.OK);

    }

    @DeleteMapping("/{commentId}") // 코멘트 삭제
    public ResponseEntity deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

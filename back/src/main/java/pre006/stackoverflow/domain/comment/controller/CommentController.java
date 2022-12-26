package pre006.stackoverflow.domain.comment.controller;


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

    @PostMapping("/{questionId}") // 질문에 대한 코멘트 추가
    public ResponseEntity postQuestionComment(@Valid @RequestBody CommentPostDto commentPostDto,
                                              @PathVariable("questionId") long questionId) {
        commentPostDto.setQuestionId(questionId);
        Comment comment = commentService.createQuestionComment(commentMapper.commentPostDtoToComment(commentPostDto), questionId);

        return new ResponseEntity<>(commentMapper.commentToCommentResponseDto(comment), HttpStatus.CREATED);

    }

    @PostMapping("/answerId") // 답변에 대한 코멘트 추가
    public ResponseEntity postAnswerComment(@Valid @RequestBody CommentPostDto commentPostDto,
                                            @PathVariable("answerId") long answerId) {
        commentPostDto.setAnswerId(answerId);
        Comment comment = commentService.createAnswerComment(commentMapper.commentPostDtoToComment(commentPostDto), answerId);

        return new ResponseEntity<>(commentMapper.commentToCommentResponseDto(comment), HttpStatus.CREATED);


    }
    @PatchMapping("/commentId") // 코멘트 내용 변경
    public ResponseEntity patchComment(@Valid @RequestBody CommentPatchDto commentPatchDto,
                                       @PathVariable("commentId") long commentId) {
        commentPatchDto.setCommentId(commentId);
        Comment comment = commentService.updateComment(commentMapper.commentPatchDtoToComment(commentPatchDto));


        return new ResponseEntity<>(commentMapper.commentToCommentResponseDto(comment), HttpStatus.OK);

    }

    @DeleteMapping("/commentId") // 코멘트 삭제
    public ResponseEntity deleteComment(@PathVariable("commentId") long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

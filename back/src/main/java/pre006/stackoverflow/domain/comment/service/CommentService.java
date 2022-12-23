package pre006.stackoverflow.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.answer.repository.AnswerRepository;
import pre006.stackoverflow.domain.answer.service.AnswerService;
import pre006.stackoverflow.domain.comment.entity.Comment;
import pre006.stackoverflow.domain.comment.repository.CommentRepository;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;
import pre006.stackoverflow.domain.question.service.QuestionService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public Comment createQuestionComment(Comment comment, long questionId) {

//        findQuestion  service 필요

        return commentRepository.save(comment);
    }

    public Comment createAnswerComment(Comment comment, long answerId) {

//        Answer answer = answerService.findAnswer(answerId);
//        comment.setAnswer(answer);
        //

        return commentRepository.save(comment);
    }

    public Comment updateComment (Comment comment, long commentId) {
        Comment findComment = findVerifiedComment(comment.getCommentId());
        Optional.ofNullable(comment.getContent()).ifPresent(content -> findComment.setContent(content));

        return commentRepository.save(findComment);
    }

    public void deleteComment (long commentId) {
        Comment findComment = findVerifiedComment(commentId);

        commentRepository.delete(findComment);
    }



    private Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment findComment = optionalComment.orElseThrow(() ->
                new NoSuchElementException("No Such Comment"));
        return findComment;
    }
}

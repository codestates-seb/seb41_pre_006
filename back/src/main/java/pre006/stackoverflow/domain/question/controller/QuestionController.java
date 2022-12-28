package pre006.stackoverflow.domain.question.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.question.dto.QuestionDto;
import pre006.stackoverflow.domain.question.mapper.QuestionMapper;
import pre006.stackoverflow.domain.question.service.QuestionService;
import pre006.stackoverflow.domain.user.mapper.UserMapper;
import pre006.stackoverflow.domain.user.service.UserService;
import pre006.stackoverflow.domain.question.entity.Question;

import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping("/questions")
@Slf4j
public class QuestionController {

    private QuestionService questionService;
    private QuestionMapper questionMapper;
    private UserMapper userMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper, UserService userService, UserMapper userMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
        this.userMapper = userMapper;
    }

    //post mapping
    @PostMapping()
    public ResponseEntity postQuestion( @Validated@RequestBody QuestionDto.QuestionPostDto questionPostDto) {
        Question question = questionService.createQuestion(questionMapper.questionPostDtoToEntity(questionPostDto));
        // log.info("postQuestion()");
        return new ResponseEntity<>(questionMapper.entityToQuestionResponseDto(question), HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity getQuestion(@PathVariable("questionId") long questionId) {
        Question question = questionService.getQuestion(questionId);
        // log.info("getQuestion()");
        // log.info("question.commentList={}", question.getComment());
        return new ResponseEntity<>(questionMapper.entityToQuestionResponseDto(question), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getAll(@RequestParam(defaultValue = "-1") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "new") String sort) {
        List<Question> questions;

        if (page > 0 && size > 0) {
            Page<Question> pageUser = questionService.getQuestions(
                    PageRequest.of(page - 1, size, Sort.by("createdAt").descending()));
            questions = pageUser.getContent();

        } else { questions = questionService.getAll(); }

        return new ResponseEntity(questionMapper.questionListToPageResponseDto(questions), HttpStatus.OK);
    }



    @PatchMapping("/{questionId}")
    public ResponseEntity patchQuestion(@PathVariable("questionId") long questionId, @Validated@RequestBody QuestionDto.QuestionPatchDto questionPatchDto) {
        questionPatchDto.setQuestionId(questionId);
        Question question = questionService.updateQuestion(questionMapper.questionPatchDtoToEntity(questionPatchDto));
        // log.info("patchQuestion()");

        return new ResponseEntity<>(questionMapper.entityToQuestionResponseDto(question), HttpStatus.OK);


    }

    //delete mapping
    @DeleteMapping("/{questionId}")
    public ResponseEntity deleteQuestion(   @PathVariable("questionId") long questionId) {
        questionService.deleteQuestion(questionId);
        // log.info("deleteQuestion()");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/upvote/{userId}/{questionId}")
    public ResponseEntity upVote(@PathVariable Long userId, @PathVariable Long questionId) {
        questionService.upVote(userId, questionId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/downvote/{userId}/{questionId}")
    public ResponseEntity downVote(@PathVariable Long userId, @PathVariable Long questionId) {
        questionService.downVote(userId, questionId);

        return new ResponseEntity(HttpStatus.OK);
    }


}

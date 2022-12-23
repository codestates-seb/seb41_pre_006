package pre006.stackoverflow.domain.question.controller;


import lombok.extern.slf4j.Slf4j;
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

@RestController
@Validated
@RequestMapping("/v1/questions")
@Slf4j
public class QuestionController {

    private QuestionService questionService;
    private QuestionMapper questionMapper;

    private UserService userService;

    private UserMapper userMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper, UserService userService, UserMapper userMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    //post mapping
    @PostMapping("")
    public ResponseEntity postQuestion( @Validated@RequestBody QuestionDto.QuestionPostDto questionPostDto, @PathVariable("user-id") Long userId) {
        Question question = questionService.createQuestion(questionMapper.questionPostDtoToEntity(questionPostDto));
        log.info("postQuestion()");
        return new ResponseEntity<>(questionMapper.entityToQuestionResponseDto(question), HttpStatus.CREATED);

    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") long questionId, @Validated@RequestBody QuestionDto.QuestionPatchDto questionPatchDto) {
        questionPatchDto.setQuestionId(questionId);
        Question question = questionService.updateQuestion(questionMapper.questionPatchDtoToEntity(questionPatchDto));
        log.info("patchQuestion()");

        return new ResponseEntity<>(questionMapper.entityToQuestionResponseDto(question), HttpStatus.OK);


    }


    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") long questionId) {
        Question question = questionService.getQuestion(questionId);
        log.info("getQuestion()");
        return new ResponseEntity<>(questionMapper.entityToQuestionResponseDto(question), HttpStatus.OK);
    }


    //delete mapping
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(   @PathVariable("question-id") long questionId) {
        questionService.deleteQuestion(questionId);
        log.info("deleteQuestion()");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

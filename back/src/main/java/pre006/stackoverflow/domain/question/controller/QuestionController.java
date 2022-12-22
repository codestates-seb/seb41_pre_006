package pre006.stackoverflow.domain.question.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.question.dto.QuestionDto;
import pre006.stackoverflow.domain.question.mapper.QuestionMapper;
import pre006.stackoverflow.domain.question.service.QuestionService;

@RestController
@Validated
@RequestMapping("/v1/questions")
@Slf4j
public class QuestionController {

    private QuestionService questionService;
    private QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    //post mapping
    @PostMapping("")
    public ResponseEntity postQuestion( @Validated@RequestBody QuestionDto.QuestionPostDto questionPostDto, @PathVariable("user-id") Long userId) {
        log.info("postQuestion()");
        return ResponseEntity.ok(questionService.createQuestion(questionMapper.questionPostDtoToEntity(questionPostDto), userId));

    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") Long questionId, @Validated@RequestBody QuestionDto.QuestionPatchDto questionPatchDto) {
        log.info("patchQuestion()");
        return ResponseEntity.ok(questionService.updateQuestion(questionMapper.questionPatchDtoToEntity(questionPatchDto, questionId)));
    }
    @GetMapping("/{question-id}")
    //get mapping
    public ResponseEntity getQuestion(@PathVariable("question-id") Long questionId) {
        log.info("getQuestion()");
        return ResponseEntity.ok(questionService.getQuestion(questionId));
    }
    //delete mapping
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion() {
        log.info("deleteQuestion()");
        return ResponseEntity.ok("deleteQuestion()");
    }


}

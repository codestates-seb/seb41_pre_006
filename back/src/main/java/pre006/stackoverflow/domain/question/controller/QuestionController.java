package pre006.stackoverflow.domain.question.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.question.mapper.QuestionMapper;
import pre006.stackoverflow.domain.question.service.QuestionService;

@RestController
@Validated
@RequestMapping("/v1/questions")
@Slf4j
public class QuestionController {

    // private final QuestionService questionService;
    // private final QuestionMapper questionMapper;

    // public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
    //     this.questionService = questionService;
    //     this.questionMapper = questionMapper;
    // }

    //post mapping
    @PostMapping
    public ResponseEntity postQuestion() {
        return ResponseEntity.created(null).build();
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{question-id}")
    //get mapping
    public ResponseEntity getQuestion() {
        return ResponseEntity.ok().build();
    }
    //delete mapping
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion() {
        return ResponseEntity.noContent().build();
    }


}

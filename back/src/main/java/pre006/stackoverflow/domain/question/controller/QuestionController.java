package pre006.stackoverflow.domain.question.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.question.dto.QuestionDto;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.mapper.QuestionMapper;
import pre006.stackoverflow.domain.question.service.QuestionService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/questions")
@Slf4j
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    // post mapping
    @PostMapping()
    public ResponseEntity postQuestion(@Validated @RequestBody QuestionDto.QuestionPostDto questionPostDto) {
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

    /**
     * Question Paging 처리를 위한 컨트롤러 입니다.
     *
     * @param page 전달해 줄 page 번호를 param으로 입력받습니다. URI에 포함되지 않은 경우 default값은 -1 입니다.
     * @param size 한페이지 담기는 Question의 개수 입니다. URI에 포함되지 않은경우 default값은 10 입니다.
     * @param sort new, answered 등 필터 기능을 구현하기 위해 구현해 놓았습니다.
     */
    @GetMapping()
    public ResponseEntity getAll(@RequestParam(defaultValue = "-1") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "") String sort,
                                 @RequestParam(required = false) String q) {

        List<Question> questions;

        if (page > 0 && size > 0 && (q != null)) {
            Page<Question> pageUser = questionService.getQuestionsSortedByQ(
                    q, PageRequest.of(page - 1, size, Sort.by("createdAt").descending()));
            questions = pageUser.getContent();

        } else if (page > 0 && size > 0 && sort.equals("unanswered")) {

            Page<Question> pageUser = questionService.getQuestionsSortedByAnswerCount(
                    PageRequest.of(page - 1, size, Sort.by("createdAt").descending()));
            questions = pageUser.getContent();

        } else if (page > 0 && size > 0) {

            Page<Question> pageUser = questionService.getQuestions(
                    PageRequest.of(page - 1, size, Sort.by("createdAt").descending()));
            questions = pageUser.getContent();
        } else {

            questions = questionService.getAll();
        }

        // if (sort.equals("unanswered"))

        return new ResponseEntity(questionMapper.questionListToPageResponseDto(questions), HttpStatus.OK);
    }


    @PatchMapping("/{questionId}")
    public ResponseEntity patchQuestion(@PathVariable("questionId") long questionId,
                                        @Validated @RequestBody QuestionDto.QuestionPatchDto questionPatchDto) {
        questionPatchDto.setQuestionId(questionId);
        Question question = questionService.updateQuestion(questionMapper.questionPatchDtoToEntity(questionPatchDto));
        // log.info("patchQuestion()");

        return new ResponseEntity<>(questionMapper.entityToQuestionResponseDto(question), HttpStatus.OK);


    }

    // delete mapping
    @DeleteMapping("/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable("questionId") long questionId) {
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

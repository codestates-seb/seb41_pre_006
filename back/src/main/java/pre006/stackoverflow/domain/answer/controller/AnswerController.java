package pre006.stackoverflow.domain.answer.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.answer.dto.AnswerPatchDto;
import pre006.stackoverflow.domain.answer.dto.AnswerPostDto;
import pre006.stackoverflow.domain.answer.dto.AnswerResponseDto;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.answer.mapper.AnswerMapper;
import pre006.stackoverflow.domain.answer.service.AnswerService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/answers")
@Validated
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PostMapping("/{questionId}") // 답변 추가
    public ResponseEntity postAnswer(@PathVariable ("questionId") long questionId, @Valid @RequestBody AnswerPostDto answerPostDto) {
        answerPostDto.setQuestionId(questionId);
        Answer answer = answerService.createAnswer(answerMapper.answerPostDtoToAnswer(answerPostDto));

        return new ResponseEntity<>(answerMapper.answerToAnswerResponseDto(answer), HttpStatus.CREATED);
    }

    @PatchMapping ("/{answerId}") // 답변 수정
    public ResponseEntity patchAnswer(@PathVariable("answerId") long answerId, @Valid @RequestBody AnswerPatchDto answerPatchDto) {
        answerPatchDto.setAnswerId(answerId);
        Answer answer = answerService.updateAnswer(answerMapper.answerPatchDtoToAnswer(answerPatchDto));

        return new ResponseEntity<>(answerMapper.answerToAnswerResponseDto(answer), HttpStatus.OK);
    }

//    @GetMapping ("/{userId}") // 해당 유저의 답변 리스트
//    public ResponseEntity getAnswer() {
//        return ResponseEntity.ok(null);
//    }

    @DeleteMapping("/{answerId}") // 답변 삭제
    public ResponseEntity deleteAnswer(@PathVariable("answerId") @Positive long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

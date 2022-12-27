package pre006.stackoverflow.domain.question.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pre006.stackoverflow.domain.question.entity.QuestionVote;
import pre006.stackoverflow.domain.question.mapper.QuestionVoteMapper;
import pre006.stackoverflow.domain.question.service.QuestionVoteService;

@RestController
@Validated
@RequestMapping("/v1/questions")
@Slf4j
public class QuestionVoteController {

    private QuestionVoteService questionVoteService;

    private QuestionVoteMapper questionVoteMapper;

    public QuestionVoteController(QuestionVoteService questionVoteService, QuestionVoteMapper questionVoteMapper) {
        this.questionVoteService = questionVoteService;
        this.questionVoteMapper = questionVoteMapper;
    }

    @PostMapping("/{questionId}/votes")
    public ResponseEntity voteQuestion(@PathVariable long questionId, @RequestParam(value = "vote", defaultValue = "0"
    ) int vote) {

        QuestionVote questionVote = questionVoteService.createQuestionVote(questionId, vote);

        return ResponseEntity.ok(questionVoteMapper.questionVoteToQuestionVoteDto(questionVote));
    }


}

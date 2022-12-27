package pre006.stackoverflow.domain.question.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.entity.QuestionVote;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;
import pre006.stackoverflow.domain.question.repository.QuestionVoteRepository;

import javax.transaction.Transactional;

@Service
@Slf4j
public class QuestionVoteService {

    private QuestionRepository questionRepository;

    private QuestionVoteRepository questionVoteRepository;

    private QuestionService questionService;

    public QuestionVoteService(QuestionRepository questionRepository, QuestionVoteRepository questionVoteRepository , QuestionService questionService) {
        this.questionRepository = questionRepository;
        this.questionVoteRepository = questionVoteRepository;
        this.questionService = questionService;
    }

    @Transactional
    public QuestionVote createQuestionVote(long questionId, int vote ) {
        QuestionVote questionVote = questionVoteRepository.findByQuestion(  questionService.findVerifiedQuestion(questionId));

        if(questionVote == null) {
            QuestionVote newVote = new QuestionVote();
            newVote.addQuestion(questionService.findVerifiedQuestion(questionId));
            newVote.setVote(vote);
            questionVoteRepository.save(newVote);
            questionService.refreshVotes(questionId);
            return newVote;

        } else {
            questionVote.setVote(vote);
            questionVoteRepository.save(questionVote);
            questionService.refreshVotes(questionId);
            return questionVote;
        }

    }

    public int getVotes(long questionId) {
        int votes = questionVoteRepository.findVoteValue(questionId);
        return votes;
    }






}

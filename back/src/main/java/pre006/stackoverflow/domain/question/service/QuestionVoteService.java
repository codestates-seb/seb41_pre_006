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

    public QuestionVoteService(QuestionRepository questionRepository, QuestionVoteRepository questionVoteRepository) {
        this.questionRepository = questionRepository;
        this.questionVoteRepository = questionVoteRepository;
    }

    @Transactional
    public QuestionVote createQuestionVote(long questionId, int vote ) {
        Question question = questionRepository.findById(questionId).get();
        QuestionVote questionVote = new QuestionVote();
        questionVote.setQuestion(question);
        questionVote.setVote(vote);
        questionVoteRepository.save(questionVote);
//        question.setVoteCount(question.getVoteCount()+vote);
        questionRepository.save(question);
        return questionVote;
    }







}

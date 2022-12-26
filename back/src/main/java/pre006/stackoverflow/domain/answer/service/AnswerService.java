package pre006.stackoverflow.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.answer.repository.AnswerRepository;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;
//import pre006.stackoverflow.domain.exception.BusinessLogicException;
//import pre006.stackoverflow.domain.exception.ExceptionCode;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerService {

    public final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());
        Optional.ofNullable(answer.getContent()).ifPresent(content -> findAnswer.setContent(content));
        return answerRepository.save(findAnswer);
    }

//    public Answer getAnswer(Long userId, Answer answer) {
//        return null;
//    }

    public Answer findAnswer (long answerId) {
        return findVerifiedAnswer(answerId);
    }

    public void deleteAnswer(long answerId) {
        Answer findAnswer = findVerifiedAnswer(answerId);

        answerRepository.delete(findAnswer);
    }

    private Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(()->
                new NoSuchElementException("No Such Answer"));

        return findAnswer;
    }
}

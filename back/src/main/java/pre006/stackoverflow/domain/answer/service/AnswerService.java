package pre006.stackoverflow.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.answer.repository.AnswerRepository;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;
import pre006.stackoverflow.domain.question.service.QuestionService;
import pre006.stackoverflow.domain.user.service.UserService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final UserService userService;
    private final QuestionService questionService;

    public Answer createAnswer(Answer answer) {
        questionService.upAnswerCount(answer.getQuestion().getQuestionId());
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());
        Optional.ofNullable(answer.getContent()).ifPresent(content -> findAnswer.setContent(content));
        return answerRepository.save(findAnswer);
    }

    public Answer findAnswer(Long answerId) {
        return findVerifiedAnswer(answerId);
    }

    public void deleteAnswer(Long answerId) {
        Answer findAnswer = findVerifiedAnswer(answerId);
        answerRepository.delete(findAnswer);
        questionService.downAnswerCount(findAnswer.getQuestion().getQuestionId());
    }

    private Answer findVerifiedAnswer(Long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() ->
                new NoSuchElementException("No Such Answer"));

        return findAnswer;
    }

    /**
     * Answer Entity 안에 upvoteUserId, downvoteUserId List를 생성해 놓았습니다. <br>
     * 해당 List에 userId를 저장하고 upvote, downvote 기능을 수행할 때 해당 List들에 어떻게 저장되어있는지 여부에 따라
     * 서비스 로직을 변경하여서 한 userId는 하나의 upvote와 downvote만 실행할 수 있도록 구현하였습니다. <br>
     *
     * @ElementCollection 을 이용해서 해당 컬렉션을 JPA에 인식시켜서 테이블을 새로 만들게 하였고 이로인해 DB에 저장되어서
     * Answer Entity와 연동되어 집니다.
     */
    public void upVote(Long userId, Long answerId) {
        // 존재하는 user인지 확인 -> 없으면 findById() 에서 지정해둔 Exception 발생
        userService.findById(userId);

        Answer answer = findAnswer(answerId);
        Long voteCount = answer.getVoteCount();

        if (answer.getUpvoteUserId().contains(userId)) {
            return;
        } else if (answer.getDownvoteUserId().contains(userId)) {
            answer.getDownvoteUserId().remove(userId);
            answer.getUpvoteUserId().add(userId);
            voteCount = voteCount + 2;
        } else {
            answer.getUpvoteUserId().add(userId);
            voteCount = voteCount + 1;
        }
        answer.setVoteCount(voteCount);
    }

    public void downVote(Long userId, Long answerId) {
        // 존재하는 user인지 확인 -> 없으면 findById() 에서 지정해둔 Exception 발생
        userService.findById(userId);

        Answer answer = findAnswer(answerId);
        Long voteCount = answer.getVoteCount();

        if (answer.getDownvoteUserId().contains(userId)) {
            return;
        } else if (answer.getUpvoteUserId().contains(userId)) {
            answer.getUpvoteUserId().remove(userId);
            answer.getDownvoteUserId().add(userId);
            voteCount = voteCount - 2;
        } else {
            answer.getDownvoteUserId().add(userId);
            voteCount = voteCount - 1;
        }
        answer.setVoteCount(voteCount);
    }
}

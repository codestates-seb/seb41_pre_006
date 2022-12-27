package pre006.stackoverflow.domain.question.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.mapper.QuestionMapper;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;
import pre006.stackoverflow.domain.user.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {


    private final QuestionRepository questionRepository;
    private final UserService userService;

    private QuestionVoteService questionVoteService;





    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {

        Optional<Question> questionOptional = questionRepository.findById(question.getQuestionId());
        if (questionOptional.isPresent()) {
            Question question1 = questionOptional.get();
            question1.setTitle(question.getTitle());
            question1.setContent(question.getContent());
            return questionRepository.save(question1);
        }
        return questionRepository.save(question);


    }

    public void deleteQuestion(long questionId) {
        questionRepository.deleteById(questionId);

    }

    public Question getQuestion(long questionId) {

    Question findQuestion = questionRepository.findById(questionId).get();
    findQuestion.setViewCount(findQuestion.getViewCount()+1);
    return findQuestion;
    }

    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        return optionalQuestion.get();
    }

    public void refreshVotes(long questionId) {
        Question question = findVerifiedQuestion(questionId);
        question.setVoteCount((long) questionVoteService.getVotes(questionId)); //error null로 들어감
        questionRepository.save(question);
    }

    /**
     * question Entity 안에 upvoteUserId, downvoteUserId List를 생성해 놓았습니다. <br>
     * 해당 List에 userId를 저장하고 upvote, downvote 기능을 수행할 때 해당 List들에 어떻게 저장되어있는지 여부에 따라
     * 서비스 로직을 변경하여서 한 userId는 하나의 upvote와 downvote만 실행할 수 있도록 구현하였습니다. <br>
     *
     * @ElementCollection 을 이용해서 해당 컬렉션을 JPA에 인식시켜서 테이블을 새로 만들게 하였고 이로인해 DB에 저장되어서
     * question Entity와 연동되어 집니다.
     */
    public void upVote(Long userId, Long questionId) {
        // 존재하는 user인지 확인 -> 없으면 findById() 에서 지정해둔 Exception 발생
        userService.findById(userId);

        Question question = questionRepository.findById(questionId).get();
        Long voteCount = question.getVoteCount();

        if (question.getUpvoteUserId().contains(userId)) {
            return;
        } else if (question.getDownvoteUserId().contains(userId)) {
            question.getDownvoteUserId().remove(userId);
            question.getUpvoteUserId().add(userId);
            voteCount = voteCount + 2;
        } else {
            question.getUpvoteUserId().add(userId);
            voteCount = voteCount + 1;
        }
        question.setVoteCount(voteCount);
    }

    public void downVote(Long userId, Long questionId) {
        // 존재하는 user인지 확인 -> 없으면 findById() 에서 지정해둔 Exception 발생
        userService.findById(userId);

        Question question = questionRepository.findById(questionId).get();
        Long voteCount = question.getVoteCount();

        if (question.getDownvoteUserId().contains(userId)) {
            return;
        } else if (question.getUpvoteUserId().contains(userId)) {
            question.getUpvoteUserId().remove(userId);
            question.getDownvoteUserId().add(userId);
            voteCount = voteCount - 2;
        } else {
            question.getDownvoteUserId().add(userId);
            voteCount = voteCount - 1;
        }
        question.setVoteCount(voteCount);
    }


}

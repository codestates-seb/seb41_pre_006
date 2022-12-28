package pre006.stackoverflow.domain.question.exclude;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pre006.stackoverflow.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionVoteRepository extends JpaRepository<QuestionVote, Long> {

    QuestionVote findByQuestion(Question question);

    List<QuestionVote> findAllByQuestion(long questionId);

    @Query("SELECT sum(qv.vote) from QuestionVote qv where qv.question.questionId = :questionId")
    int findVoteValue(@Param("questionId") long questionId);



}

package pre006.stackoverflow.domain.question.repository;

import pre006.stackoverflow.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import pre006.stackoverflow.domain.question.entity.QuestionVote;

import java.util.List;


public interface QuestionVoteRepository extends JpaRepository<QuestionVote, Long> {


}

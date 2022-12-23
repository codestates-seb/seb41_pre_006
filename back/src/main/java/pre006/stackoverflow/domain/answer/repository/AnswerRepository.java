package pre006.stackoverflow.domain.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pre006.stackoverflow.domain.answer.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}

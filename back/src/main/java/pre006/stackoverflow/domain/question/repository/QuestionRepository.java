package pre006.stackoverflow.domain.question.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import pre006.stackoverflow.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {





}


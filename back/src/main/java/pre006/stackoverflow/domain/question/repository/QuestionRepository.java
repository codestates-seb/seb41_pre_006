package pre006.stackoverflow.domain.question.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import pre006.stackoverflow.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}


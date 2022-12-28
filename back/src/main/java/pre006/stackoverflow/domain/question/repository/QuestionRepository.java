package pre006.stackoverflow.domain.question.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pre006.stackoverflow.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Modifying
    @Query("update QUESTION q set q.viewCount = :viewCount where q.questionId = :questionId")
    int updateViewCount(@Param("viewCount") Long viewCount, @Param("questionId") Long questionId);
}


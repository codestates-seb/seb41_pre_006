package pre006.stackoverflow.domain.question.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pre006.stackoverflow.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Modifying
    @Query("update QUESTION q set q.viewCount = :viewCount where q.questionId = :questionId")
    int updateViewCount(@Param("viewCount") Long viewCount, @Param("questionId") Long questionId);

    // Page<Question> findBy

    @Modifying
    @Query("update QUESTION q set q.answerCount = :answerCount where q.questionId = :questionId")
    int setAnswerCount(@Param("answerCount") int answerCount, @Param("questionId") Long questionId);

    Page<Question> findAllByAnswerCountEquals(int number, Pageable pageable);

    // @Query("select q from QUESTION q where q.title like :q ")
    Page<Question> findAllByTitleContains(String q, Pageable pageable);
}



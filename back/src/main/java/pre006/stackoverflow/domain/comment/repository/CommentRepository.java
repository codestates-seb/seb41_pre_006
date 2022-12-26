package pre006.stackoverflow.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pre006.stackoverflow.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

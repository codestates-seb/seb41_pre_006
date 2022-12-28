package pre006.stackoverflow.domain.tag.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pre006.stackoverflow.domain.tag.entity.Tag;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByTagId(Long tagId);
    Optional<Tag> findByTagName(String tagName);



}


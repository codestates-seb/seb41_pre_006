package pre006.stackoverflow.domain.tag.dto;

import lombok.*;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.entity.QuestionTag;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;
import pre006.stackoverflow.domain.tag.entity.Tag;
import pre006.stackoverflow.domain.tag.repository.TagRepository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

        private Long tagId;
        private String tagName;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class TagPostDto {
            @NotBlank
            private String tagName;

        }


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class TagResponseDto extends BaseTime {
            private Long tagId;
        }
}

package pre006.stackoverflow.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.question.entity.Question;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


public class QuestionDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionPostDto {
        @NotBlank
        private String title;
        @NotBlank
        private String content;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionPatchDto  {
        private Long questionId;
        private String title;
        private String content;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionResponseDto extends BaseTime {
        private Long questionId;
        private String title;
        private String content;
        private Long viewCount;
        private Long vote;
        private String userName;
        private Long userId;
        private Long answerCount;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }


}


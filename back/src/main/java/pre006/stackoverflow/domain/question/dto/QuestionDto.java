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
    public  class QuestionResponeDto extends BaseTime {
        private Long questionId;
        private String title;
        private String content;
        private Long viewCount;
        private String userName;
        private Long userId;
        private Long answerCount;

        public QuestionResponeDto(Question question) {
            this.questionId = question.getQuestionId();
            this.title = question.getTitle();
            this.content = question.getContent();
            this.viewCount = question.getViewCount();
            this.userName = question.getUser().getName();
            this.userId = question.getUser().getUserId();
            this.answerCount = (long) question.getAnswerList().size();
        }
    }


}


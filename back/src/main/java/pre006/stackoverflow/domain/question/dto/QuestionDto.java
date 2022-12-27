package pre006.stackoverflow.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre006.stackoverflow.domain.answer.entity.Answer;
import pre006.stackoverflow.domain.audit.BaseTime;
import pre006.stackoverflow.domain.comment.dto.CommentResponseDto;
import pre006.stackoverflow.domain.comment.entity.Comment;
import pre006.stackoverflow.domain.user.dto.UserResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


public class QuestionDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionPostDto {
        @NotNull
        private Long userId;
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
        private Long voteCount;
        private String userName;
        private Long userId;
        private List<CommentResponseDto> comments;
        private List<AResponseDto> answerList;
        // private Long answerCount;
    }
}


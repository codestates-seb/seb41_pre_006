package pre006.stackoverflow.domain.response;

import lombok.Getter;

public enum ExceptionCode {
    QUESTION_NOT_FOUND(404,"Question Not Found"),
    QUESTION_EXISTS(409, "Question Exists"),
    QUESTION_CANNOT_CHANGE(403,"Question Can Not Be Changed"),

    Comment_NOT_FOUND(404,"Comment Not Found"),
    Comment_EXISTS(409, "Comment Exists"),
    Comment_CANNOT_CHANGE(403,"Comment Can Not Be Changed"),

    ANSWER_NOT_FOUND(404,"Answer Not Found"),
    ANSWER_EXISTS(409, "Answer Exists"),
    ANSWER_CANNOT_CHANGE(403,"Answer Can Not Be Changed"),
    ANSWER_DELETED(405, "Answer Already Deleted"),

    USER_NOT_FOUND(404,"User Not Found"),
    EMAIL_EXISTS(409, "Email Exists"),
    NICKNAME_EXISTS(409, "Nickname Exists"),

    USER_NOT_ALLOWED(403, "User Not Allowed"),
    USER_CANNOT_CHANGE(403,"User Can Not Be Changed"),

    VOTED(409, "Already Voted"),

    UNAUTHORIZED(401, "ID 또는 Password가 일치하지 않습니다.");


    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
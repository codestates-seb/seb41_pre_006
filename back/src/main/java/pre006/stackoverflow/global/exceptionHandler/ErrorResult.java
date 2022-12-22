package pre006.stackoverflow.global.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Exception이 발생했을 때 발생코드와 메시지를 프론트에게 전달해 주기 위한 Response 객체
 */
@Data
@AllArgsConstructor
public class ErrorResult {
    private String code;
    private String message;
}

package com.thinh.onlinebookstore.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException; // Import ResponseStatusException
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private String status;
    private int code;
    private String message;
    private T data;
    private Object error;

    public ResponseEntity<ApiResponse<T>> toResponseEntity() {
        return new ResponseEntity<>(this, HttpStatus.valueOf(this.code));
    }

    // Convenience method for success responses
    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .status("success")
                .code(HttpStatus.OK.value())
                .message(message)
                .data(data)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return success(data, "OK");
    }

    public static <T> ResponseEntity<ApiResponse<T>> success() {
        return success(null, "OK");
    }

    // Convenience method for error responses
    public static ResponseEntity<ApiResponse<?>> error(HttpStatus status, String message, Object error) {
        ApiResponse<?> response = ApiResponse.builder()
                .status("error")
                .code(status.value())
                .message(message)
                .error(error)
                .build();
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<ApiResponse<?>> error(HttpStatus status, String message) {
        return error(status, message, null);
    }

    // Convenience method for handling exceptions
//    public static ResponseEntity<ApiResponse<?>> exception(ResponseStatusException ex) {
//        HttpStatus status = ex.getStatusCode();
//        ApiResponse<?> response = ApiResponse.builder()
//                .status("error")
//                .code(status.value())
//                .message(ex.getReason())
//                .error(null) // You might want to include exception details in the error field
//                .build();
//        return new ResponseEntity<>(response, status);
//    }

    public static ResponseEntity<ApiResponse<?>> exception(Exception ex, HttpStatus status, String message) {
        ApiResponse<?> response = ApiResponse.builder()
                .status("error")
                .code(status.value())
                .message(message)
                .error(ex.getMessage()) // You might want to include exception details in the error field
                .build();
        return new ResponseEntity<>(response, status);
    }

}
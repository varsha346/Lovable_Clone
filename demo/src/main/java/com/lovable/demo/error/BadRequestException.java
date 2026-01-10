package com.lovable.demo.error;


import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class BadRequestException extends RuntimeException {
String message;


}

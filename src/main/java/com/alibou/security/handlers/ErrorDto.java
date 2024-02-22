package com.alibou.security.handlers;


import com.alibou.security.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private ErrorCodes Code;
    private String message;
    private List<String> errors = new ArrayList<>();

}

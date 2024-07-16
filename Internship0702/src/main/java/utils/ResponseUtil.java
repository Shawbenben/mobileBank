package utils;

import ccnu.mb.internship0702.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtil {
    private String code;
    private String message;
    private User user;
}

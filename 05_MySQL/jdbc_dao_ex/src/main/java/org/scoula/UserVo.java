package org.scoula;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVo {
    private final int id;
    private final String email;
    private final String password;
}

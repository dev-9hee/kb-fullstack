package org.scoula.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo implements Cloneable {
    private static int gid = 1; // Todo Id 발급을 위한 스태틱 변수

    private int id;
    private String title;
    private String description;
    private boolean done;
    private Date date; // 임포트 주의!

    @Builder
    public Todo(String title, String description, boolean done) {
        this(gid++, title, description, done, new Date());
    }

    @Override
    public Object clone() { // 부모에서는 protected 였던 것을 public 으로 변경
        try {
            return super.clone(); // 얕은 복사
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRegDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

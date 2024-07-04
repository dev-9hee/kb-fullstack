package pattern.builder;

import java.util.Date;

public class Memo {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date date;

    public Memo() {}

    // Getter, Setter, toString()

    public static class Builder {
        private Long id;
        private String title;
        private String content;
        private String writer;
        private Date date;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Memo build() { // 중요
            return new Memo(this);
//          return new Memo(id, title, content, writer, date);
        }
    } // end of Builder

//  public Memo(Long id, String title, String content, String writer, Date date) { }
    private Memo(Builder builder) {
        id = builder.id;
        title = builder.title;
        content = builder.content;
        writer = builder.writer;
        date = builder.date;
    }
} // end of Memo

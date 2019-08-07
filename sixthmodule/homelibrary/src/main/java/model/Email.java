package homelibrary.src.main.java.model;

public class Email {

    private String from;
    private String password;
    private String to;
    private String subject;
    private String message;

    public Email(EmailBuilder eMailBuilder) {
        this.from = eMailBuilder.from;
        this.password = eMailBuilder.password;
        this.to = eMailBuilder.to;
        this.subject = eMailBuilder.subject;
        this.message = eMailBuilder.message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class EmailBuilder {

        private String from;
        private String password;
        private String to;
        private String subject;
        private String message;

        public static EmailBuilder getInstance() {
            return new EmailBuilder();
        }

        public EmailBuilder from(String from) {
            this.from = from;
            return this;
        }

        public EmailBuilder password(String password) {
            this.password = password;
            return this;
        }

        public EmailBuilder to(String to) {
            this.to = to;
            return this;
        }

        public EmailBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailBuilder message(String message) {
            this.message = message;
            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }

}

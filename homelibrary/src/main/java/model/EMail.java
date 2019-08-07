package model;

public class EMail {

    private String from;
    private String password;
    private String to;
    private String subject;
    private String message;

    public EMail(EMailBuilder eMailBuilder) {
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

    public static class EMailBuilder {

        private String from;
        private String password;
        private String to;
        private String subject;
        private String message;

        public static EMailBuilder getInstance() {
            return new EMailBuilder();
        }

        public EMailBuilder from(String from) {
            this.from = from;
            return this;
        }

        public EMailBuilder password(String password) {
            this.password = password;
            return this;
        }

        public EMailBuilder to(String to) {
            this.to = to;
            return this;
        }

        public EMailBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public EMailBuilder message(String message) {
            this.message = message;
            return this;
        }

        public EMail build() {
            return new EMail(this);
        }
    }

}

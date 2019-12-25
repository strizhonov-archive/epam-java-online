package notebook.Model;

import java.io.Serializable;
import java.util.Calendar;

public class Note implements Serializable {

    private String topic;
    private Calendar cal;
    private String email;
    private String message;

    public Note(String topic, Calendar cal, String email, String message) {
        this.topic = topic;
        this.cal = cal;
        this.email = email;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public Calendar getCalendar() {
        return cal;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Note:\n" +
                "topic='" + topic + '\'' + "\n" +
                "date=" + (cal.get(Calendar.YEAR))
                + "-" + (cal.get(Calendar.MONTH))
                + "-" + cal.get(Calendar.DAY_OF_MONTH) + "\n" +
                "email='" + email + '\'' + "\n" +
                "message='" + message + '\'' + "\n";
    }
}

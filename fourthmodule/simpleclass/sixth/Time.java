package simpleclass.sixth;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public void setHours(int hours) {
        if (hours > 0 && hours < 24) {
            this.hours = hours;
        } else {
            this.hours = 0;
        }
    }

    public void setMinutes(int minutes) {
        if (minutes > 0 && minutes < 60) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
    }

    public void setSeconds(int seconds) {
        if (seconds > 0 && seconds < 60) {
            this.seconds = seconds;
        } else {
            this.seconds = 0;
        }
    }

    public void addSeconds(int i) {
        int modifiedSeconds = seconds + i;
        int size = modifiedSeconds / 60;
        addMinutes(size);
        seconds = modifiedSeconds % 60;
    }

    public void addMinutes(int i) {
        int modifiedMinutes = minutes + i;
        int size = modifiedMinutes / 60;
        addHours(size);
        minutes = modifiedMinutes % 60;
    }

    public void addHours(int i) {
        int modifiedHours = hours + i;
        hours = modifiedHours % 24;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}

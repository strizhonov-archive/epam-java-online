package third;

import java.util.Arrays;

/**
 * Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
 * выходных и праздничных днях.
 */

public class Calendar {

    private Day[] days;

    public Calendar() {}

    public Calendar(Day[] days) {
        this.days = days;
    }

    public Day[] getDays() {
        return days;
    }

    public void update(Day day) {
        for (int i = 0; i < days.length; i++) {
            if (days[i].getDate().getDay() == day.getDate().getDay()
                    && days[i].getDate().getMonth() == day.getDate().getMonth()) {
                days[i] = day;
                return;
            }
        }
        days = Arrays.copyOf(days, days.length + 1);
        days[days.length - 1] = day;

    }

    public class Day {

        private DayType dayType;
        private Date date;

        public Day(DayType dayType, Date date) {
            this.dayType = dayType;
            this.date = date;
        }

        public DayType getDayType() {
            return dayType;
        }

        public void setDayType(DayType dayType) {
            this.dayType = dayType;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public class Date {
            private int day;
            private int month;

            public Date(int day, int month) {
                if (month < 1 || month > 12) {
                    month = 1;
                }
                if (day < 1) {
                    day = 1;
                }
                switch (month) {
                    case 2:
                        if (day > 29) {
                            day = day % 29;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (day > 30) {
                            day = day % 30;
                        }
                        break;
                    default: // 1, 3, 5, 7, 8, 10, 12
                        if (day > 31) {
                            day = day % 31;
                        }
                        break;
                }
                this.day = day;
                this.month = month;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }
        }

    }

    enum DayType {
        HOLIDAY,
        DAY_OFF,
        WEEKDAY
    }

}

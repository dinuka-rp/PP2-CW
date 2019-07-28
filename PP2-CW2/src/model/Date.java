package model;

public class Date {
    private int year;
    private int month;
    private int day;


    public Date(int day, int month, int year) {
        this.year = year;

        setMonth(month);           //validate month
        setDay(day);             //validate day

        System.out.printf("Date object constructor for date : %s\n", this);           //checking input date
    }

    private void setMonth(int month) {               //validate month
        if (month > 0 && month <= 12) {
            this.month = month;
        } else {
            System.out.printf("Invalid month (%d) set to 1", month);
            this.month = 1;             //inserted to maintain object in consistent state
        }
    }

    private void setDay(int day) {               //validate day         //always returning 1!!!!!!!!!!

        int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (day > 0 && day <= daysPerMonth[month]) {                             //check if date is within range of month
            this.day = day;
        }

        if (month == 2 && day == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            this.day = day;
        }

        System.out.printf("Invalid day (%d) set to 1\n", day);
        this.day = 1;             //inserted to maintain object in consistent state
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

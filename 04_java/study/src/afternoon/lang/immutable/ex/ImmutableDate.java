package afternoon.lang.immutable.ex;

public class ImmutableDate {
    private final int year;
    private final int month;
    private final int day;

    public ImmutableDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public ImmutableDate setYear(int year) {
        return new ImmutableDate(year, month, day);
    }

    public int getMonth() {
        return month;
    }

    public ImmutableDate setMonth(int month) {
        return new ImmutableDate(year, month, day);
    }

    public int getDay() {
        return day;
    }

    public ImmutableDate setDay(int day) {
        return new ImmutableDate(year, month, day);
    }

    @Override
    public String toString() {
        return "ImmutableDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

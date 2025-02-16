/**
 * The Date class implements a comprehensive date handling system based on the Gregorian calendar.
 * This class provides functionality for date creation, manipulation, comparison, and validation
 * with support for leap years and various calendar rules.
 * 
 * The class handles dates from year 0 to 9999, implementing:
 * - Date validation including leap year rules
 * - Date comparison operations
 * - Day difference calculations
 * - Next day computation
 * - String formatting
 * 
 * All dates are validated according to the Gregorian calendar rules:
 * - Regular years have 365 days
 * - Leap years occur every 4 years
 * - Century years are leap years only if divisible by 400
 * 
 * @author Shimon Esterkin (@SemionVlad)
 * @version 2023B
 */
public class Date {
    // Month Constants
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    // Instance variables
    private int _day;
    private int _month;
    private int _year;

    // Private helper methods for date validation

    /**
     * Checks if a month has 30 days.
     *
     * @param month the month to check
     * @return true if the month has 30 days
     */
    private boolean ifThirtyDays(int month) {
        return month == APRIL || 
               month == JUNE || 
               month == SEPTEMBER || 
               month == NOVEMBER;
    }

    /**
     * Checks if a month has 31 days.
     *
     * @param month the month to check
     * @return true if the month has 31 days
     */
    private boolean ifThirtyOneDays(int month) {
        return month == JANUARY || 
               month == MARCH || 
               month == MAY || 
               month == JULY || 
               month == AUGUST || 
               month == OCTOBER || 
               month == DECEMBER;
    }

    /**
     * Determines if a year is a leap year according to the Gregorian calendar rules:
     * - Year is a leap year if divisible by 4
     * - Exception: century years must be divisible by 400
     *
     * @param year the year to check
     * @return true if the year is a leap year
     */
    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    /**
     * Verifies if a date is valid according to the Gregorian calendar rules.
     *
     * @param day the day of the month
     * @param month the month (1-12)
     * @param year the year (0-9999)
     * @return true if the date is valid
     */
    private boolean verifyDate(int day, int month, int year) {
        if (year < 0 || year > 9999) {
            return false;
        }
        
        if (month < 1 || month > 12) {
            return false;
        }
    
        if (day < 1) {
            return false;
        }
    
        if (month == FEBRUARY) {
            return isLeapYear(year) ? day <= 29 : day <= 28;
        }

        if (ifThirtyDays(month)) {
            return day <= 30;
        }
        
        if (ifThirtyOneDays(month)) {
            return day <= 31;
        }

        return false;
    }

    /**
     * Calculates the number of days since the start of the Christian era.
     * Uses a modified version of the Gregorian calendar algorithm.
     *
     * @param day the day of the month
     * @param month the month (1-12)
     * @param year the year
     * @return number of days since the start of the Christian era
     */
    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + 
               ((month + 1) * 306)/10 + (day - 62);
    }

    // Constructors

    /**
     * Constructs a new Date object.
     * If the date is invalid, defaults to 01/01/2000.
     *
     * @param day the day of the month
     * @param month the month (1-12)
     * @param year the year
     */
    public Date(int day, int month, int year) {
        if (!verifyDate(day, month, year)) {
            this._day = 1;
            this._month = 1;
            this._year = 2000;
            return;
        }
        this._day = day;
        this._month = month;
        this._year = year;
    }

    /**
     * Copy constructor - creates a new Date with the same values as another Date.
     *
     * @param other the Date to copy
     */
    public Date(Date other) {
        this._day = other.getDay();
        this._month = other.getMonth();
        this._year = other.getYear();
    }

    // Getters and Setters

    /**
     * @return the day of the month
     */
    public int getDay() {
        return this._day;
    }

    /**
     * @return the month (1-12)
     */
    public int getMonth() {
        return this._month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return this._year;
    }

    /**
     * Sets the day if the resulting date would be valid.
     *
     * @param dayToSet the new day value
     */
    public void setDay(int dayToSet) {
        if (verifyDate(dayToSet, this._month, this._year)) {
            this._day = dayToSet;
        }
    }

    /**
     * Sets the month if the resulting date would be valid.
     *
     * @param monthToSet the new month value
     */
    public void setMonth(int monthToSet) {
        if (verifyDate(this._day, monthToSet, this._year)) {
            this._month = monthToSet;
        }
    }

    /**
     * Sets the year if the resulting date would be valid.
     *
     * @param yearToSet the new year value
     */
    public void setYear(int yearToSet) {
        if (verifyDate(this._day, this._month, yearToSet)) {
            this._year = yearToSet;
        }
    }

    // Comparison Methods

    /**
     * Checks if this date equals another date.
     *
     * @param other the date to compare with
     * @return true if the dates are equal
     */
    public boolean equals(Date other) {
        return this._day == other.getDay() && 
               this._month == other.getMonth() && 
               this._year == other.getYear();
    }

    /**
     * Checks if this date comes before another date.
     *
     * @param other the date to compare with
     * @return true if this date is before the other date
     */
    public boolean before(Date other) {
        if (this._year < other.getYear()) {
            return true;
        } 
        if (this._year > other.getYear()) {
            return false;
        }
        
        if (this._month < other.getMonth()) {
            return true;
        } 
        if (this._month > other.getMonth()) {
            return false;
        }
        
        return this._day < other.getDay();
    }

    /**
     * Checks if this date comes after another date.
     *
     * @param other the date to compare with
     * @return true if this date is after the other date
     */
    public boolean after(Date other) {
        return !before(other) && !equals(other);
    }

    /**
     * Calculates the number of days between this date and another date.
     *
     * @param other the date to calculate difference with
     * @return number of days between the dates
     */
    public int difference(Date other) {
        return calculateDate(this._day, this._month, this._year) - 
               calculateDate(other.getDay(), other.getMonth(), other.getYear());
    }

    /**
     * Creates a new Date object representing the next day.
     *
     * @return a new Date object for tomorrow
     */
    public Date tomorrow() {
        int nextDay = this._day;
        int nextMonth = this._month;
        int nextYear = this._year;
    
        if (verifyDate(nextDay + 1, nextMonth, nextYear)) {
            nextDay++;
        } else {
            nextDay = 1;
            nextMonth++;
            
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }
    
        return new Date(nextDay, nextMonth, nextYear);
    }

    /**
     * Returns a string representation of the date in DD/MM/YYYY format.
     *
     * @return formatted string representation of the date
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this._day, this._month, this._year);
    }
}

# Date Class
## Gregorian Calendar Date Implementation

**Author:** Shimon Esterkin (SemionVlad)  
**Version:** 2023B

## Overview
The Date class provides a robust implementation of date handling based on the Gregorian calendar system. It supports date validation, comparison, and calculations while handling special cases like leap years and month-specific day limits.

## Class Structure
```
Date.java
├── Constants
│   └── Month Constants (JANUARY through DECEMBER)
├── Instance Variables
│   ├── day (private int)
│   ├── month (private int)
│   └── year (private int)
├── Helper Methods
│   ├── ifThirtyDays()
│   ├── ifThirtyOneDays()
│   ├── isLeapYear()
│   ├── verifyDate()
│   └── calculateDate()
└── Public Interface
    ├── Constructors
    ├── Getters/Setters
    ├── Comparison Methods
    └── Utility Methods
```

## Features
1. **Date Validation**
   - Comprehensive date verification
   - Leap year handling
   - Month-specific day limits

2. **Date Comparison**
   - Equality checking
   - Before/after comparisons
   - Day difference calculation

3. **Date Manipulation**
   - Next day computation
   - Date copying
   - Individual component updates

## Usage Examples

### Creating Dates
```java
// Create a new date
Date date1 = new Date(25, 12, 2023);

// Copy an existing date
Date date2 = new Date(date1);

// Invalid date defaults to 01/01/2000
Date invalidDate = new Date(31, 2, 2023);
```

### Comparing Dates
```java
// Check if one date is before another
boolean isBefore = date1.before(date2);

// Check if dates are equal
boolean areEqual = date1.equals(date2);

// Calculate days between dates
int daysDiff = date1.difference(date2);
```

### Manipulating Dates
```java
// Get tomorrow's date
Date tomorrow = date1.tomorrow();

// Modify date components
date1.setDay(15);
date1.setMonth(6);
date1.setYear(2024);
```

## Technical Details

### Date Validation Rules
1. Year limits: 0-9999
2. Month limits: 1-12
3. Day limits:
   - 31 days: Jan, Mar, May, Jul, Aug, Oct, Dec
   - 30 days: Apr, Jun, Sep, Nov
   - 28/29 days: Feb (leap year dependent)

### Leap Year Rules
- Year divisible by 4 is a leap year
- Century years must be divisible by 400
- Examples:
  - 2000: Leap year (divisible by 400)
  - 2100: Not a leap year (divisible by 100 but not 400)
  - 2024: Leap year (divisible by 4)

## Method Descriptions

### Constructors
- `Date(int day, int month, int year)` - Creates new date
- `Date(Date other)` - Creates copy of existing date

### Getters/Setters
- `getDay()`, `getMonth()`, `getYear()` - Return components
- `setDay(int)`, `setMonth(int)`, `setYear(int)` - Set components

### Comparison Methods
- `equals(Date)` - Checks date equality
- `before(Date)` - Checks if date is earlier
- `after(Date)` - Checks if date is later
- `difference(Date)` - Calculates days between dates

### Utility Methods
- `tomorrow()` - Returns next day's date
- `toString()` - Returns "DD/MM/YYYY" format

## Implementation Notes

### Error Handling
- Invalid dates in constructor default to 01/01/2000
- Invalid component updates are ignored
- All operations maintain date validity

### Performance
- Basic operations are O(1)
- Date calculations optimize for common cases
- Memory efficient implementation

## Requirements
- Java Development Kit (JDK)
- No external dependencies

## Testing Recommendations
1. Test date validation
   - Valid dates in different months
   - Leap year dates
   - Invalid dates
   - Edge cases (year boundaries)

2. Test comparisons
   - Equal dates
   - Sequential dates
   - Dates across year boundaries

3. Test calculations
   - Day differences
   - Tomorrow calculations
   - Leap year transitions

## Known Limitations
1. No time zone support
2. Limited to years 0-9999
3. No BC dates support
4. No partial date support

## Future Enhancements
- Support for different calendar systems
- Extended year range
- Time zone support
- Date parsing from strings
- Date formatting options

---
*Note: This implementation is designed for educational purposes and demonstrates date handling concepts in Java.*

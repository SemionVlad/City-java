# City Class
## Urban Location and Demographics Management System

**Author:** Shimon Esterkin (SemionVlad)  
**Version:** 2023B

## Dependencies
This class requires two additional classes that should be included in your project:
- [Point Class](https://github.com/SemionVlad/Point-java) - For handling geographical coordinates
- [Date Class](https://github.com/SemionVlad/Date-java) - For managing establishment dates

## Overview
The City class provides a comprehensive implementation for managing city data, including geographical locations, demographics, and establishment information. It combines spatial data management using the Point class and temporal data handling using the Date class.

## Class Structure
```
City.java
├── Dependencies
│   ├── Point.java
│   └── Date.java
├── Instance Variables
│   ├── cityName (String)
│   ├── cityCenter (Point)
│   ├── centralStation (Point)
│   ├── numOfResidents (long)
│   ├── noOfNeighborhoods (int)
│   └── dateOfEstablishment (Date)
├── Constructors
│   ├── Full Constructor (with date)
│   ├── Partial Constructor (without date)
│   └── Copy Constructor
└── Methods
    ├── Getters/Setters
    ├── Location Management
    └── Demographic Operations
```

## Features
1. **Location Management**
   - City center coordinates
   - Central station coordinates
   - Distance calculations
   - Location modifications

2. **Demographic Data**
   - Population tracking
   - Neighborhood counting
   - Population updates

3. **Historical Information**
   - Establishment date handling
   - Date comparison operations
   - Timeline validations

## Project Setup
1. Clone the required dependencies:
```bash
git clone [https://github.com/SemionVlad/Point-java]
git clone [https://github.com/SemionVlad/Date-java]
git clone [https://github.com/SemionVlad/City-java]
```

2. Ensure the Point and Date classes are in your build path
3. Compile the City class:
```bash
javac -cp ".:path/to/Point:path/to/Date" City.java
```

## Usage Examples

### Creating a City
```java
// Create a new city with establishment date
City newYork = new City("New York", 1, 1, 1800,  // Date
                       40, 74,                    // City center coordinates
                       40, 73,                    // Station coordinates
                       8400000, 5);              // Demographics

// Create a city without establishment date
City london = new City("London", 51, 0,          // City center
                      51, 1,                      // Station
                      9000000, 32);              // Demographics
```

### Managing City Data
```java
// Update population
city.addResidents(1000);

// Move central station
city.moveCentralStation(1, -1);

// Calculate distances
double distance = city.distanceBetweenCenterAndStation();

// Create new city based on existing one
City newCity = city.newCity("New City", 5, 5);
```

## Technical Details

### Constraints
- Non-negative population values
- Minimum of 1 neighborhood
- Valid date ranges (as per Date class)
- Non-negative coordinates (as per Point class)

### Data Validation
- Population: Enforced non-negative
- Neighborhoods: Minimum value of 1
- Coordinates: Validated through Point class
- Dates: Validated through Date class

## Implementation Notes

### Memory Management
- Deep copies for all object references
- Defensive copying in getters/setters
- Immutable string handling

### Error Handling
- Invalid inputs are corrected to valid values
- Population updates maintain non-negative values
- Coordinate changes respect Point class constraints

## Requirements
- Java Development Kit (JDK)
- Point class implementation
- Date class implementation

## Testing Recommendations
1. Location Management
   - Coordinate updates
   - Distance calculations
   - Movement operations

2. Demographics
   - Population updates
   - Neighborhood modifications
   - Validation checks

3. Date Operations
   - Establishment date comparisons
   - Date difference calculations
   - Timeline validations

## Known Limitations
1. Single central station
2. Basic demographic model
3. Limited to 2D coordinates
4. Single establishment date

## Future Enhancements
- Multiple station support
- Advanced demographic tracking
- 3D coordinate support
- Multiple historical dates

---
*Note: This implementation demonstrates object composition and data management in Java.*

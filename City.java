public class City {
    
    // Instance variables
    private String cityName;
    private Point cityCenter;
    private Point centralStation;
    private long numOfResidents;
    private int noOfNeighborhoods;
    private Date dateOfEstablishment;

    /**
     * Constructs a new City with all attributes including establishment date.
     *
     * @param cityName           the name of the city
     * @param d                  day of establishment
     * @param m                  month of establishment
     * @param y                  year of establishment
     * @param cityCenterX        x-coordinate of city center
     * @param cityCenterY        y-coordinate of city center
     * @param centralStationX    x-coordinate of central station
     * @param centralStationY    y-coordinate of central station
     * @param numOfResidents     number of residents (non-negative)
     * @param noOfNeighborhoods  number of neighborhoods (minimum 1)
     */
    public City(String cityName, int d, int m, int y, int cityCenterX, int cityCenterY, 
                int centralStationX, int centralStationY, long numOfResidents, int noOfNeighborhoods) {
        this.cityName = new String(cityName);
        this.dateOfEstablishment = new Date(d, m, y);
        this.cityCenter = new Point(cityCenterX, cityCenterY);
        this.centralStation = new Point(centralStationX, centralStationY);
        this.noOfNeighborhoods = (noOfNeighborhoods < 1) ? 1 : noOfNeighborhoods;
        this.numOfResidents = (numOfResidents < 0) ? 0 : numOfResidents;
    }

    /**
     * Constructs a new City without establishment date.
     *
     * @param cityName           the name of the city
     * @param cityCenterX        x-coordinate of city center
     * @param cityCenterY        y-coordinate of city center
     * @param centralStationX    x-coordinate of central station
     * @param centralStationY    y-coordinate of central station
     * @param numOfResidents     number of residents (non-negative)
     * @param noOfNeighborhoods  number of neighborhoods (minimum 1)
     */
    public City(String cityName, int cityCenterX, int cityCenterY, 
                int centralStationX, int centralStationY, long numOfResidents, int noOfNeighborhoods) {
        this.cityName = new String(cityName);
        this.cityCenter = new Point(cityCenterX, cityCenterY);
        this.centralStation = new Point(centralStationX, centralStationY);
        this.noOfNeighborhoods = (noOfNeighborhoods < 1) ? 1 : noOfNeighborhoods;
        this.numOfResidents = (numOfResidents < 0) ? 0 : numOfResidents;
    }

    /**
     * Copy constructor - creates a new City with the same attributes as another City.
     *
     * @param other the City to copy
     */
    public City(City other) {
        this.cityName = other.getCityName();
        this.cityCenter = new Point(other.getCityCenter());
        this.centralStation = new Point(other.getCentralStation());
        this.noOfNeighborhoods = (other.getNoOfNeighborhoods() < 1) ? 1 : other.getNoOfNeighborhoods();
        this.numOfResidents = (other.getNumOfResidents() < 0) ? 0 : other.getNumOfResidents();
        if (other.dateOfEstablishment != null) {
            this.dateOfEstablishment = new Date(other.getDateOfEstablishment());
        }
    }

    // Getters
    
    /**
     * @return the name of the city
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @return a copy of the establishment date
     */
    public Date getDateOfEstablishment() {
        return new Date(dateOfEstablishment.getDay(), 
                       dateOfEstablishment.getMonth(), 
                       dateOfEstablishment.getYear());
    }

    /**
     * @return a copy of the city center point
     */
    public Point getCityCenter() {
        return new Point(cityCenter);
    }

    /**
     * @return a copy of the central station point
     */
    public Point getCentralStation() {
        return new Point(centralStation);
    }

    /**
     * @return the number of residents
     */
    public long getNumOfResidents() {
        return numOfResidents;
    }

    /**
     * @return the number of neighborhoods
     */
    public int getNoOfNeighborhoods() {
        return noOfNeighborhoods;
    }

    // Setters
    
    /**
     * @param cityName the new name of the city
     */
    public void setCityName(String cityName) {
        this.cityName = new String(cityName);
    }

    /**
     * @param cityCenter the new city center location
     */
    public void setCityCenter(Point cityCenter) {
        this.cityCenter = new Point(cityCenter);
    }

    /**
     * @param centralStation the new central station location
     */
    public void setCentralStation(Point centralStation) {
        this.centralStation = new Point(centralStation);
    }

    /**
     * Sets the number of residents, ensuring it's non-negative.
     *
     * @param numOfResidents the new number of residents
     */
    public void setNumOfResidents(long numOfResidents) {
        this.numOfResidents = (numOfResidents < 0) ? 0 : numOfResidents;
    }

    /**
     * Sets the number of neighborhoods, ensuring it's at least 1.
     *
     * @param noOfNeighborhoods the new number of neighborhoods
     */
    public void setNoOfNeighborhoods(int noOfNeighborhoods) {
        this.noOfNeighborhoods = (noOfNeighborhoods < 1) ? 1 : noOfNeighborhoods;
    }

    // Utility Methods
    
    /**
     * Checks if this city is equal to another city.
     *
     * @param other the city to compare with
     * @return true if all attributes are equal
     */
    public boolean equals(City other) {
        return centralStation.equals(other.getCentralStation()) &&
               cityCenter.equals(other.getCityCenter()) &&
               cityName.equals(other.getCityName()) &&
               numOfResidents == other.getNumOfResidents() &&
               noOfNeighborhoods == other.getNoOfNeighborhoods();
    }

    /**
     * Moves the central station by the specified deltas.
     *
     * @param deltaX the change in x-coordinate
     * @param deltaY the change in y-coordinate
     */
    public void moveCentralStation(int deltaX, int deltaY) {
        centralStation.move(deltaX, deltaY);
    }

    /**
     * Updates the number of residents while ensuring non-negative value.
     *
     * @param residentsUpdate the change in number of residents
     * @return true if update successful, false if resulted in negative value
     */
    public boolean addResidents(long residentsUpdate) {
        if (numOfResidents + residentsUpdate >= 0) {
            numOfResidents += residentsUpdate;
            return true;
        }
        numOfResidents = 0;
        return false;
    }

    /**
     * Calculates the distance between city center and central station.
     *
     * @return the Euclidean distance between center and station
     */
    public double distanceBetweenCenterAndStation() {
        return cityCenter.distance(centralStation);
    }

    /**
     * Creates a new city based on this city with modified location.
     *
     * @param newCityName the name for the new city
     * @param dX the x-coordinate shift
     * @param dY the y-coordinate shift
     * @return a new City object with modified parameters
     */
    public City newCity(String newCityName, int dX, int dY) {
        Date newDate = new Date(dateOfEstablishment);
        newDate = newDate.tomorrow();
        
        Point newCityCenter = new Point(cityCenter);
        newCityCenter.move(dX, dY);
        
        Point newCentralStation = new Point(centralStation);
        newCentralStation.move(dX, dY);
        
        return new City(newCityName, newDate.getDay(), newDate.getMonth(), newDate.getYear(),
                       newCityCenter.getX(), newCityCenter.getY(),
                       newCentralStation.getX(), newCentralStation.getY(), 0, 1);
    }

    /**
     * Checks if the city was established between two dates.
     *
     * @param date1 first date
     * @param date2 second date
     * @return true if establishment date is between the given dates
     */
    public boolean cityEstablishedBetweenDates(Date date1, Date date2) {
        return (dateOfEstablishment.before(date2) && dateOfEstablishment.after(date1)) ||
               (dateOfEstablishment.before(date1) && dateOfEstablishment.after(date2));
    }

    /**
     * Calculates the difference in days between establishment date and given date.
     *
     * @param other the date to compare with
     * @return number of days difference
     */
    public int establishmentDateDiff(Date other) {
        return dateOfEstablishment.difference(other);
    }
}
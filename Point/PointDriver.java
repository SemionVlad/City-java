/**
 * The PointDriver class tests the functionality of the Point class.
 * It performs a series of tests to verify Point operations including:
 * - Point creation and copying
 * - Point equality comparison
 * - Coordinate modification
 * - Triangle property verification
 * - Midpoint calculation
 *
 * @author Shimon Esterkin (SemionVlad)
 * @version 2023B
 */
public class PointDriver {
    
    // Constant for floating-point comparison
    private static final double EPSILON = 0.0001;
    
    /**
     * Main method to run the Point class tests.
     * Executes a sequence of operations to verify Point functionality.
     *
     * Test Sequence:
     * 1. Create point p1 at origin (0,0)
     * 2. Create point p2 at (0,3)
     * 3. Create point p3 as copy of p1
     * 4. Test equality between p1 and p3
     * 5. Modify p3's x-coordinate
     * 6. Check if points form equilateral triangle
     * 7. Calculate midpoint between p1 and p3
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test 1 & 2: Create initial points
        Point p1 = new Point(0, 0);       // Origin point
        Point p2 = new Point(0, 3);       // Point 3 units up
        
        // Test 3: Create copy of p1
        Point p3 = new Point(p1);         // Copy of origin point
        
        // Test 4: Check point equality
        if (p1.equals(p3)) {
            System.out.println("Points " + p1.toString() + " and " 
                             + p3.toString() + " are equal");
        } else {
            System.out.println("Points " + p1.toString() + " and " 
                             + p3.toString() + " are not equal");
        }
        
        // Test 5: Modify point coordinate
        p3.setX(4);                       // Move p3 4 units right
        
        // Test 6: Check for equilateral triangle
        boolean isEquilateral = 
            Math.abs(p1.distance(p2) - p2.distance(p3)) < EPSILON && 
            Math.abs(p2.distance(p3) - p3.distance(p1)) < EPSILON && 
            Math.abs(p1.distance(p2) - p3.distance(p1)) < EPSILON;
        
        if (isEquilateral) {
            System.out.println("Points " + p1.toString() + ", "
                           + p2.toString() + " and " 
                           + p3.toString() + " represent a equilateral triangle");
        } else {
            System.out.println("Points " + p1.toString() + ", " 
                           + p2.toString() + " and " 
                           + p3.toString() + " don't represent a equilateral triangle");
        }
        
        // Test 7: Calculate midpoint
        Point m1 = p1.middle(p3);         // Midpoint between p1 and p3
        System.out.println("The middle point between " + p1.toString() + " and " + p3.toString() + " is: " + m1.toString() + "\n");
    }
}

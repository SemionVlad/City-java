/**
 * The DateDriver class tests the functionality of the Date class.
 * It performs a series of tests to verify Date operations including:
 * - Date creation and copying
 * - Date equality comparison
 * - Next day calculation
 * - Date ordering comparison
 *
 * This driver demonstrates the core functionality of the Date class
 * through a sequence of operations and verifications.
 *
 * @author Shimon Esterkin (SemionVlad)
 * @version 2023B
 */
public class DateDriver {
    
    /**
     * Main method to run the Date class tests.
     * Executes a sequence of operations to verify Date functionality.
     *
     * Test Sequence:
     * 1. Create date d1 for March 31, 2023
     * 2. Create date d2 as copy of d1
     * 3. Verify equality between d1 and d2
     * 4. Create date d3 as next day after d1
     * 5. Verify chronological ordering between d1 and d3
     *
     * Expected Results:
     * - Dates d1 and d2 should be equal
     * - Date d3 should be one day after d1
     * - d1 should come before d3
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test 1: Create initial date (March 31, 2023)
        Date d1 = new Date(31, 3, 2023);
        
        // Test 2: Create copy of d1
        Date d2 = new Date(d1);
        
        // Test 3: Verify date equality
        if (d1.equals(d2)) {
            System.out.println("Same date.\n");
        } else {
            System.out.println("Different dates.\n");
        }
        
        // Test 4: Create next day using tomorrow()
        Date d3 = new Date(d1.tomorrow());
        
        // Test 5: Verify chronological ordering
        if (d1.before(d3)) {
            System.out.println(d1.toString() + " comes before " + 
                             d3.toString() + "\n");
        }
    }
}

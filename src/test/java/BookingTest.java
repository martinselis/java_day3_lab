import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Bedroom guestRoom1;
    private Booking booking1;

    @Before
    public void setup() {
        guestRoom1 = new Bedroom(1, 2, "Single");
        guestRoom1.setRate(100);
        booking1 = new Booking(guestRoom1, 10);
    }

    @Test
    public void getProperties() {
        assertEquals(1, booking1.getRoomNumber());
    }

    @Test
    public void getTotalBill() {
        assertEquals(1000, booking1.calculateBill());
    }
}

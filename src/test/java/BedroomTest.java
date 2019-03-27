import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom guestRoom1;
    private Guest guest;

    @Before
    public void setup() {
        guestRoom1 = new Bedroom(1, 2, "Single");
        guest = new Guest("Bob");
    }

    @Test
    public void getProperties() {
        assertEquals(1, guestRoom1.getNumber());
        assertEquals(2, guestRoom1.getCapacity());
        assertEquals("Single", guestRoom1.getRoomType());
        assertEquals(0, guestRoom1.getGuestCount());
    }

    @Test
    public void addGuest() {
        guestRoom1.addGuest(guest);
        assertEquals(1, guestRoom1.getGuestCount());
    }

    @Test
    public void removeGuest() {
        guestRoom1.addGuest(guest);
        guestRoom1.removeGuest(guest);
        assertEquals(0, guestRoom1.getGuestCount());
    }
}

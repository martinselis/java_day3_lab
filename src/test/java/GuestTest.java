import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    @Test
    public void getName() {
        Guest guest = new Guest("Bob");
        assertEquals("Bob", guest.getName());
    }
}

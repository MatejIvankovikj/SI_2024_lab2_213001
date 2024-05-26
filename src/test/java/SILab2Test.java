import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testEveryBranch() {

        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!", exception.getMessage()); //RuntimeException

        Item item1 = new Item(null, null, 100, 0);
        assertTrue(SILab2.checkCart(Collections.singletonList(item1), 100));
        assertEquals("unknown", item1.getName()); //nepostoecki produkt i nema barkod

        Item item2 = new Item("item2", "12a4", 100, 0);
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Collections.singletonList(item2), 100));
        assertEquals("Invalid character in item barcode!", exception.getMessage()); //pogreshen karakter vo barkod

        Item item3 = new Item("item3", "1234", 100, 0.2f);
        assertTrue(SILab2.checkCart(Collections.singletonList(item3), 100)); //suma <= payment

        Item item4 = new Item("item4", "1234", 200, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(item4), 100)); //suma > payment ne mozhe da kupi
    }

    @Test
    void testMultipleCondition() {

        Item item1 = new Item("item1", "0123", 350, 0.1f);
        assertTrue(SILab2.checkCart(Collections.singletonList(item1), 30)); // suma = 35 - 30 = 5, payment = 30 --> True

        Item item2 = new Item("item2", "0123", 250, 0.1f);
        assertTrue(SILab2.checkCart(Collections.singletonList(item2), 30)); // suma = 25, payment = 30 --> True

        Item item3 = new Item("item3", "0123", 350, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(item3), 30)); // suma = 350, payment = 30 --> False

        Item item4 = new Item("item4", "1123", 350, 0.1f);
        assertFalse(SILab2.checkCart(Collections.singletonList(item4), 30)); // suma = 35, payment = 30 --> False

        Item item5 = new Item("item5", "1123", 250, 0);
        assertTrue(SILab2.checkCart(Collections.singletonList(item5), 300)); // suma = 250, payment = 300 --> True

        Item item6 = new Item("item6", "1123", 250, 0.1f);
        assertTrue(SILab2.checkCart(Collections.singletonList(item6), 30)); // suma = 25, payment = 30 --> True
    }
}

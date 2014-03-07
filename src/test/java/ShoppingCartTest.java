import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ShoppingCartTest {

  @Test
  public void testGetSubTotalReturnsSumOfAllProductPrices() {

    List<Product> products = mock(List.class);
    Iterator<Product> iterator = mock(Iterator.class);

    Product p1 = mock(Product.class);
    Product p2 = mock(Product.class);
    Product p3 = mock(Product.class);

    when(p1.getPrice()).thenReturn(10.50);
    when(p2.getPrice()).thenReturn(2.50);
    when(p3.getPrice()).thenReturn(7.00);

    when(products.iterator()).thenReturn(iterator);
    when(iterator.hasNext()).thenReturn(true, true, true, false);
    when(iterator.next()).thenReturn(p1).thenReturn(p2).thenReturn(p3);

    ShoppingCart cart = new ShoppingCart(products);
    double subtotal = cart.getSubTotal();

    // Contrived example -- we wouldn't generally test to see if an iterator had been called 4 times
    // Included to show that we can verify that methods have been called multiple times
    verify(iterator, times(4)).hasNext();
    verify(iterator, times(3)).next();

    // Epsilon needed when testing floating point values due to the 
    // possibility of floating-point errors.
    // Verifies that Math.abs(expected - actual) < epsilon
    assertEquals(20.0, subtotal, 0.01);
  }

}

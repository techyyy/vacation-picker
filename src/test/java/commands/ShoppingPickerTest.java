package commands;

import com.trips.commands.ShoppingPicker;
import com.trips.entity.Food;
import com.trips.entity.Shopping;
import com.trips.entity.Transport;
import com.trips.entity.TransportType;
import com.trips.service.PickerService;
import com.trips.service.ShoppingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ShoppingPicker.class)
public class ShoppingPickerTest {

    private static final List<Shopping> AVAILABLE_SHOPPING = List.of(
            new Shopping("test", Food.INCLUDED, new Transport(TransportType.TRAIN, 20.d),
                    20.d, LocalDate.of(2000, 2, 2), LocalDate.of(2000, 3, 3)
                    ,List.of("test", "test")));

    @InjectMocks
    private ShoppingPicker shoppingPicker;

    @Mock
    private ShoppingService shoppingService;

    @Mock
    private PickerService pickerService;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPrintShopping() {
        when(shoppingService.retrieveAvailableShoppings()).thenReturn(AVAILABLE_SHOPPING);
        when(pickerService.chooseTrip(AVAILABLE_SHOPPING)).thenReturn(true);
        assertTrue(shoppingPicker.pickShopping());
    }

}

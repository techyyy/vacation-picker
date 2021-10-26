package commands;

import com.trips.commands.ExcursionPicker;
import com.trips.entity.Excursion;
import com.trips.entity.Food;
import com.trips.entity.Transport;
import com.trips.entity.TransportType;
import com.trips.service.ExcursionService;
import com.trips.service.PickerService;
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

@SpringBootTest(classes = ExcursionPicker.class)
public class ExcursionPickerTest {

    private static final List<Excursion> AVAILABLE_EXCURSIONS = List.of(
            new Excursion("test", Food.INCLUDED, new Transport(TransportType.TRAIN, 20.d),
                    20.d, LocalDate.of(2000, 2, 2), LocalDate.of(2000, 3, 3)
                    , "test", "test"));

    @InjectMocks
    private ExcursionPicker excursionPicker;

    @Mock
    private ExcursionService excursionService;

    @Mock
    private PickerService pickerService;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPrintExcursion() {
        when(excursionService.retrieveAvailableExcursions()).thenReturn(AVAILABLE_EXCURSIONS);
        when(pickerService.chooseTrip(AVAILABLE_EXCURSIONS)).thenReturn(true);
        assertTrue(excursionPicker.pickExcursion());
    }

}

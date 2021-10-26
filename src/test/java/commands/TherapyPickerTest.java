package commands;

import com.trips.commands.TherapyPicker;
import com.trips.entity.Food;
import com.trips.entity.Therapy;
import com.trips.entity.Transport;
import com.trips.entity.TransportType;
import com.trips.service.PickerService;
import com.trips.service.TherapyService;
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

@SpringBootTest(classes = TherapyPicker.class)
public class TherapyPickerTest {

    private static final List<Therapy> AVAILABLE_THERAPIES = List.of(
            new Therapy("test", Food.INCLUDED, new Transport(TransportType.TRAIN, 20.d),
                    20.d, LocalDate.of(2000, 2, 2), LocalDate.of(2000, 3, 3)
                    , "test", "test", List.of("test", "test")));

    @InjectMocks
    private TherapyPicker therapyPicker;

    @Mock
    private TherapyService therapyService;

    @Mock
    private PickerService pickerService;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPrintTherapy() {
        when(therapyService.retrieveAvailableTherapies()).thenReturn(AVAILABLE_THERAPIES);
        when(pickerService.chooseTrip(AVAILABLE_THERAPIES)).thenReturn(true);
        assertTrue(therapyPicker.pickTherapy());
    }

}
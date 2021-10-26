package commands;

import com.trips.commands.RecreationPicker;
import com.trips.entity.*;
import com.trips.service.PickerService;
import com.trips.service.RecreationService;
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

@SpringBootTest(classes = RecreationPicker.class)
public class RecreationPickerTest {

    private static final List<Recreation> AVAILABLE_RECREATIONS = List.of(
            new Recreation("test", Food.INCLUDED, new Transport(TransportType.TRAIN, 20.d),
                    20.d, LocalDate.of(2000, 2, 2), LocalDate.of(2000, 3, 3)
                    , "test", RecreationType.SEA));

    @InjectMocks
    private RecreationPicker recreationPicker;

    @Mock
    private RecreationService recreationService;

    @Mock
    private PickerService pickerService;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPrintRecreation() {
        when(recreationService.retrieveAvailableRecreations()).thenReturn(AVAILABLE_RECREATIONS);
        when(pickerService.chooseTrip(AVAILABLE_RECREATIONS)).thenReturn(true);
        assertTrue(recreationPicker.pickRecreation());
    }

}

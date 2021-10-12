package commands;

import com.trips.commands.CruisePicker;
import com.trips.entity.*;
import com.trips.service.ConsoleReaderService;
import com.trips.service.CruiseService;
import com.trips.service.TicketService;
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

@SpringBootTest(classes = CruisePicker.class)
public class CruisePickerTest {

    private static final List<Cruise> AVAILABLE_CRUISES = List.of(
            new Cruise("test", Food.INCLUDED, new Transport(TransportType.TRAIN, 20.d),
                    20.d, LocalDate.of(2000, 2, 2), LocalDate.of(2000, 3, 3)
                    , "test", List.of("test", "test")));

    @InjectMocks
    private CruisePicker cruisePicker;

    @Mock
    private CruiseService cruiseService;

    @Mock
    private TicketService ticketService;

    @Mock
    private ConsoleReaderService pickerUtils;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPrintCruise() {
        when(cruiseService.retrieveAvailableCruises()).thenReturn(AVAILABLE_CRUISES);
        when(ticketService.printTicket(AVAILABLE_CRUISES.get(0))).thenReturn(true);
        when(pickerUtils.getLine()).thenReturn("0");
        assertTrue(cruisePicker.pickCruise());
    }

}

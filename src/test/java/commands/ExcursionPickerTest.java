package commands;

import com.trips.commands.ExcursionPicker;
import com.trips.entity.*;
import com.trips.service.ConsoleReaderService;
import com.trips.service.ExcursionService;
import com.trips.service.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

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
    private TicketService ticketService;

    @Mock
    private ConsoleReaderService pickerUtils;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPrintExcursion() {
        when(excursionService.retrieveAvailableExcursions()).thenReturn(AVAILABLE_EXCURSIONS);
        when(ticketService.printTicket(AVAILABLE_EXCURSIONS.get(0))).thenReturn(true);
        when(pickerUtils.getLine()).thenReturn("0");
        assertTrue(excursionPicker.pickExcursion());
    }

}

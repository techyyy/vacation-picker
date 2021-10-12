package commands;

import com.trips.commands.TherapyPicker;
import com.trips.entity.*;
import com.trips.service.ConsoleReaderService;
import com.trips.service.TherapyService;
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
    private TicketService ticketService;

    @Mock
    private ConsoleReaderService pickerUtils;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPrintTherapy() {
        when(therapyService.retrieveAvailableTherapies()).thenReturn(AVAILABLE_THERAPIES);
        when(ticketService.printTicket(AVAILABLE_THERAPIES.get(0))).thenReturn(true);
        when(pickerUtils.getLine()).thenReturn("0");
        assertTrue(therapyPicker.pickTherapy());
    }

}
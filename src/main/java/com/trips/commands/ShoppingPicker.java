package com.trips.commands;

import com.trips.entity.Shopping;
import com.trips.service.PickerService;
import com.trips.service.ShoppingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class ShoppingPicker {

    private final PickerService pickerService;
    private final ShoppingService shoppingService;

    public boolean pickShopping() {
        List<Shopping> available = shoppingService.retrieveAvailableShoppings();
        System.out.println("Available shopping trips: ");
        return pickerService.chooseTrip(available);
    }
}

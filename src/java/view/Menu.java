package java.view;

import java.io.IOException;
import java.util.List;

public class Menu {
    private int selectedItemIndex = 0;
    private final String header;
    private final List<String> items;

    public Menu(String header, List<String> items) {
        this.header = header;
        this.items = items;
    }

    private void drawMenu() throws IOException {
        Runtime.getRuntime().exec("cls");

        System.out.println(header);

        for(int i = 0, n = items.size(); i < n; i++) {
            if(i == selectedItemIndex) {
                System.out.print("* ");
            }

            System.out.println(items.get(i));
        }
    }

    private void selectPrev() {
        selectedItemIndex = (selectedItemIndex - 1) % (items.size() + 1);
    }
    private void selectNext() {
        selectedItemIndex = (selectedItemIndex + 1) % (items.size() + 1);
    }
}

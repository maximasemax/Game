package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.Item;
import model.ItemConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ItemService implements ItemServiceOption {

    Scanner scanner = new Scanner(System.in);


    @Override
    public void showAllItem() throws IOException {
        System.out.println(getItem());
    }

    @Override
    public List<Item> getItem() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ItemConfiguration itemConfiguration = objectMapper.readValue(new File("src\\\\\\\\main\\\\\\\\resources\\\\\\\\items.yml"), ItemConfiguration.class);
        return itemConfiguration.getItems();
    }

    @Override
    public Item choseItem() throws IOException {
        showAllItem();
        System.out.println("Please chose item and write name.");
        String nameOfItem = scanner.nextLine().toLowerCase(Locale.ROOT);
        List<Item> itemList = getItem();
        for (Item item : itemList) {
            if (item.getName().toLowerCase(Locale.ROOT).equals(nameOfItem)) {
                System.out.println("Предмет выбран!");
                return item;
            }
        }
        System.out.println("Такого предмета нету(");
        return null;
    }

    @Override
    public Item choseItemBot() throws IOException {
        Random random = new Random();
        System.out.println("Предмет выбран у бота!");

        return getItem().get(random.nextInt(getItem().size()));
    }

}

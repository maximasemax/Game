package service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.impl.Item;
import model.impl.ItemConfigurationImpl;
import service.ItemServiceOptional;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ItemServiceImpl implements ItemServiceOptional {

    Scanner scanner = new Scanner(System.in);


    @Override
    public void showAllItem() throws IOException {
        List<Item> items = new ArrayList<>(getItem());

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Item item : items) {
            count += 1;
            stringBuilder.append(count + ". Name: " + item.getName());
            stringBuilder.append("\n");
            stringBuilder.append("Attack skill: " + item.getDamageSkill());
            stringBuilder.append("\n");
            stringBuilder.append("Defence skill: " + item.getDefenceSkill());
            stringBuilder.append("\n");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    @Override
    public List<Item> getItem() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ItemConfigurationImpl itemConfiguration = objectMapper.readValue(new File("src\\main\\resources\\items.yml"), ItemConfigurationImpl.class);
        return itemConfiguration.getItems();
    }

    @Override
    public List<Item> choseItem() throws IOException {
        showAllItem();
        System.out.println("Please chose item and write item number.");
        List<Item> itemList = new ArrayList<>(getItem());
        List<Item> itemsChose = new ArrayList<>();
        int amount = 3;
        while (amount != 0) {
            amount -= 1;
            int nameOfItem = scanner.nextInt();
            itemsChose.add(itemList.get(nameOfItem - 1));
        }
        System.out.println("Items selected!");
        return itemsChose;
    }

    @Override
    public List<Item> choseItemBot() throws IOException {
        Random random = new Random();
        System.out.println("Bots chose!");
        ArrayList<Item> items = new ArrayList<>(getItem());
        ArrayList<Item> itemsBot = new ArrayList<>();

        int amount = 3;
        while (amount != 0) {
            amount = amount - 1;
            Item itemBot = items.get(random.nextInt(getItem().size()));
            while (itemsBot.contains(itemBot)) {
                itemBot = items.get(random.nextInt(getItem().size()));
            }
            itemsBot.add(itemBot);


        }
        return itemsBot;
    }

}

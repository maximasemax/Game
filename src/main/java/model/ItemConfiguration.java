package model;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public class ItemConfiguration implements ItemConfigurationOption{

    private String name;
    private List<Item> items;

    public ItemConfiguration(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public ItemConfiguration() {
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ItemConfiguration{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }


    @Override
    public void addItem(Item item) throws JsonProcessingException {
        items.add(item);
    }
}

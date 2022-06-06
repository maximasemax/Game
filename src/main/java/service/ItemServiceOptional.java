package service;

import model.impl.Item;

import java.io.IOException;
import java.util.List;

public interface ItemServiceOptional {
    void showAllItem() throws IOException;

    List<Item> getItem() throws IOException;

    List<Item> choseItem() throws IOException;


    List<Item> choseItemBot() throws IOException;
}

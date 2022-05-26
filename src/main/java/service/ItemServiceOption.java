package service;

import model.Item;

import java.io.IOException;
import java.util.List;

public interface ItemServiceOption {
    void showAllItem() throws IOException;

    List<Item> getItem() throws IOException;

    Item choseItem() throws IOException;


    Item choseItemBot() throws IOException;
}

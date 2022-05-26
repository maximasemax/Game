package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.impl.Item;

public interface ItemConfigurationOption {
    void addItem(Item item) throws JsonProcessingException;
}

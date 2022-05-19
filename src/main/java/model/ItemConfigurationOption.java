package model;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ItemConfigurationOption {
    void addItem(Item item) throws JsonProcessingException;
}

package com.ism.dreamssellersv2.service;

import com.ism.model.ItemCreateDTO;
import com.ism.model.ItemDTO;
import com.ism.model.UpdateItemRequest;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getItems();
    ItemDTO getItemById(Integer itemId);
    ItemDTO createItem(ItemCreateDTO itemCreateDTO);
    ItemDTO updateItem(Integer itemId, UpdateItemRequest updateItemRequest);
    void deleteItem(Integer itemId);
}
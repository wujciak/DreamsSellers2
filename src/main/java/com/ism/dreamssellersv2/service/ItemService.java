package com.ism.dreamssellersv2.service;

import com.ism.model.ItemCreateDTO;
import com.ism.model.ItemDTO;
import com.ism.model.UpdateItemRequest;

import java.util.List;

public interface ItemService {
    ItemDTO createItem(ItemCreateDTO itemCreateDTO);
    void deleteItem(Integer itemId);
    ItemDTO getItemById(Integer itemId);
    List<ItemDTO> getItems();
    ItemDTO updateItem(Integer itemId, UpdateItemRequest updateItemRequest);
}
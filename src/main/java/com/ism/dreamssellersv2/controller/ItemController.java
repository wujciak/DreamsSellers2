package com.ism.dreamssellersv2.controller;

import com.ism.api.ItemApi;
import com.ism.model.ItemCreateDTO;
import com.ism.model.ItemDTO;
import com.ism.model.UpdateItemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController implements ItemApi {
    @Override
    public ResponseEntity<ItemDTO> createItem(ItemCreateDTO itemCreateDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteItem(Integer itemId) {
        return null;
    }

    @Override
    public ResponseEntity<ItemDTO> getItemById(Integer itemId) {
        return null;
    }

    @Override
    public ResponseEntity<List<ItemDTO>> getItems() {
        return null;
    }

    @Override
    public ResponseEntity<ItemDTO> updateItem(Integer itemId, UpdateItemRequest updateItemRequest) {
        return null;
    }
}

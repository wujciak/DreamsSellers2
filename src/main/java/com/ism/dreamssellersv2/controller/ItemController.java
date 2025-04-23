package com.ism.dreamssellersv2.controller;

import com.ism.api.ItemApi;
import com.ism.dreamssellersv2.service.ItemService;
import com.ism.model.ItemCreateDTO;
import com.ism.model.ItemDTO;
import com.ism.model.UpdateItemRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ItemController implements ItemApi {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public ResponseEntity<ItemDTO> createItem(ItemCreateDTO itemCreateDTO) {
        return ResponseEntity.ok(itemService.createItem(itemCreateDTO));
    }

    @Override
    public ResponseEntity<Void> deleteItem(Integer itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ItemDTO> getItemById(Integer itemId) {
        return ResponseEntity.ok(itemService.getItemById(itemId));
    }

    @Override
    public ResponseEntity<List<ItemDTO>> getItems() {
        return ResponseEntity.ok(itemService.getItems());
    }

    @Override
    public ResponseEntity<ItemDTO> updateItem(Integer itemId, UpdateItemRequest updateItemRequest) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Feature not implemented yet");
    }
}
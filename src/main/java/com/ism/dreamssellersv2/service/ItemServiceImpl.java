package com.ism.dreamssellersv2.service;

import com.ism.dreamssellersv2.mapper.ItemMapper;
import com.ism.dreamssellersv2.model.ItemEntity;
import com.ism.dreamssellersv2.repository.ItemRepository;
import com.ism.model.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDTO> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::itemEntityToItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItemById(Integer itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        return itemMapper.itemEntityToItemDTO(itemEntity);
    }

    @Override
    public ItemDTO createItem(ItemCreateDTO itemCreateDTO) {
        ItemEntity itemEntity = itemMapper.itemCreateDTOToItemEntity(itemCreateDTO);
        return itemMapper.itemEntityToItemDTO(itemRepository.save(itemEntity));
    }

    @Override
    public ItemDTO updateItem(Integer itemId, UpdateItemRequest updateItemRequest) {
        return null; // not implemented
    }

    @Override
    public void deleteItem(Integer itemId) {
        if (!itemRepository.existsById(itemId)) {
            throw new RuntimeException("Item not found");
        }
        itemRepository.deleteById(itemId);
    }
}
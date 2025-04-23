package com.ism.dreamssellersv2.service;

import com.ism.dreamssellersv2.mapper.ItemMapper;
import com.ism.dreamssellersv2.model.ItemEntity;
import com.ism.dreamssellersv2.repository.ItemRepository;
import com.ism.model.ItemCreateDTO;
import com.ism.model.ItemDTO;
import com.ism.model.UpdateItemRequest;
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
    public ItemDTO createItem(ItemCreateDTO itemCreateDTO) {
        ItemEntity itemEntity = itemMapper.itemCreateDTOToItemEntity(itemCreateDTO);
        return itemMapper.itemEntityToItemDTO(itemRepository.save(itemEntity));
    }

    @Override
    public void deleteItem(Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public ItemDTO getItemById(Integer itemId) {
        return itemRepository.findById(itemId)
                .map(itemMapper::itemEntityToItemDTO)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public List<ItemDTO> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::itemEntityToItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO updateItem(Integer itemId, UpdateItemRequest updateItemRequest) {
        ItemEntity itemEntity = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        if (updateItemRequest.getPrice() != null) {
            itemEntity.setPrice(updateItemRequest.getPrice());
        }
        if (updateItemRequest.getStock() != null) {
            itemEntity.setStock(updateItemRequest.getStock());
        }
        return itemMapper.itemEntityToItemDTO(itemRepository.save(itemEntity));
    }
}
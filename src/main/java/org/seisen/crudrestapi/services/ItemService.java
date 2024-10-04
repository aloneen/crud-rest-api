package org.seisen.crudrestapi.services;


import org.seisen.crudrestapi.entity.ItemEntity;
import org.seisen.crudrestapi.exceptions.ItemAlreadyExistsException;
import org.seisen.crudrestapi.exceptions.ItemNotFoundException;
import org.seisen.crudrestapi.models.Item;
import org.seisen.crudrestapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public Item getItemById(Long id) throws ItemNotFoundException {
        ItemEntity entity = itemRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));

        return Item.toModel(entity);
    }

    public List<ItemEntity> getAllItems() {
        return (List<ItemEntity>) itemRepository.findAll();
    }


    public void createNewItem(ItemEntity item) throws ItemAlreadyExistsException {
        if(itemRepository.existsById(item.getId())) {
            throw new ItemAlreadyExistsException("Item already exists");
        }
        itemRepository.save(item);
    }

    public void updateItem(ItemEntity item) throws ItemNotFoundException {
        if (!itemRepository.existsById(item.getId())) {
            throw new ItemNotFoundException("Item not found");
        }
        itemRepository.save(item);
    }

    public void deleteItemById(Long id) throws ItemNotFoundException {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotFoundException("Item not found");
        }

        itemRepository.deleteById(id);
    }
}

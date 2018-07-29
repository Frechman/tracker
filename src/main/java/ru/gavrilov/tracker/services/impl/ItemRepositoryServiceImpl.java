package ru.gavrilov.tracker.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gavrilov.exceptions.ResourceNotFoundExceptions;
import ru.gavrilov.tracker.dao.ItemRepository;
import ru.gavrilov.tracker.models.Item;
import ru.gavrilov.tracker.services.ItemRepositoryService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemRepositoryServiceImpl implements ItemRepositoryService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemRepositoryServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void create(Item item) {
        item.setDateCreate(Timestamp.valueOf(LocalDateTime.now()));
        itemRepository.save(item);
    }

    @Override
    public void update(String itemId, Item itemDetails) {
        Item foundItem = this.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Item", "id", itemId));

        foundItem.setName(itemDetails.getName());
        foundItem.setDescription(itemDetails.getDescription());
        itemRepository.save(foundItem);
    }

    @Override
    public void delete(String id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(String id) {
        return itemRepository.findById(id);
    }

    @Override
    public Optional<Item> findByName(String name) {
        return itemRepository.findByName(name);
    }
}
package ru.gavrilov.tracker.services;

import ru.gavrilov.tracker.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepositoryService {

    void create(Item item);

    void update(Long id, Item item);

    void delete(Long id);

    List<Item> findAll();

    Optional<Item> findById(Long id);

    Optional<Item> findByName(String name);
}

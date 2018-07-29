package ru.gavrilov.tracker.services;

import ru.gavrilov.tracker.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepositoryService {

    void create(Item item);

    void update(String id, Item item);

    void delete(String id);

    List<Item> findAll();

    Optional<Item> findById(String id);

    Optional<Item> findByName(String name);
}

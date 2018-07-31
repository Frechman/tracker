package ru.gavrilov.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gavrilov.tracker.models.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByNameContaining(String name);

    /**
     * Тест.
     * Возвращает все записи, которые содержат введеные значения в имени или номере.
     *
     * @param name         of an item.
     * @param numberOfItem item.
     * @return list of a founded items.
     */
    List<Item> findAllByNameContainingOrIdContaining(String name, Long numberOfItem);
}

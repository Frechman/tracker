package ru.gavrilov.tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gavrilov.tracker.models.Item;
import ru.gavrilov.tracker.services.ItemRepositoryService;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemRepositoryService itemRepositoryService;

    @Autowired
    public ItemController(ItemRepositoryService itemRepositoryService) {
        this.itemRepositoryService = itemRepositoryService;
    }

    @GetMapping("/add")
    public String addItem() {
        return "addItem";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("item") Item item) {
        itemRepositoryService.create(item);
        return "redirect:/items/listItems";

    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("items", itemRepositoryService.findAll());
        return "listItems";
    }

//    Item create(Item item);
//
//    void update(String id, Item item);
//
//    void delete(String id);
//
//    List<Item> findAll();
//
//    Item findById(String id);
//
//    Item findByName(String name)

}

package ru.gavrilov.tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String addItemPage() {
        return "addItem";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("item") Item item) {
        itemRepositoryService.create(item);
        return "redirect:/items/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("items", itemRepositoryService.findAll());
        return "listItems";
    }

    @GetMapping("/{id}")
    public String showPageItem(@PathVariable("id") Long id, Model model) {
        model.addAttribute("item", itemRepositoryService.findById(id));
        return "showItem";
    }

    @PutMapping("/update")
    public String updateItem() {
        return "";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemRepositoryService.delete(id);
        return "redirect:/items/all";
    }

    @PostMapping("/items/findByName")
    public String findByName(@RequestParam("name") String name) {
        return "";
    }

//    +Item create(Item item);
//
//    void update(String id, Item item);
//
//    +void delete(String id);
//
//    +List<Item> findAll();
//
//    Item findById(String id);
//
//    Item findByName(String name)

}

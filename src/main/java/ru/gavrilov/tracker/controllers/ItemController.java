package ru.gavrilov.tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.tracker.models.Item;
import ru.gavrilov.tracker.services.ItemRepositoryService;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemRepositoryService service;

    @Autowired
    public ItemController(ItemRepositoryService itemRepositoryService) {
        this.service = itemRepositoryService;
    }

    @GetMapping("/add")
    public String addItemPage() {
        return "addItem";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("item") Item item) {
        service.create(item);
        return "redirect:/items/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        return "listItems";
    }

    @GetMapping("/{id}")
    public String showPageItem(@PathVariable("id") Long id, Model model) {
        model.addAttribute("item", service.findById(id));
        return "showItem";
    }

    @PutMapping("/update")
    public String updateItem() {
        return "";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/items/all";
    }

    @PostMapping("/items/findByName")
    public String findByName(@RequestParam("name") String name) {

        return "";
    }

    @PostMapping("/search")
    public String findById(@ModelAttribute("idOrName") String idOrName) {

        return "redirect:/items/search";
    }

    @GetMapping("/search")
    public String findByIdPage(String idOrName, Model model) {
        model.addAttribute("found", service.findAllByName(idOrName));
        return "search";
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

package ru.gavrilov.tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.tracker.exceptions.ResourceNotFoundExceptions;
import ru.gavrilov.tracker.models.Item;
import ru.gavrilov.tracker.services.ItemRepositoryService;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemRepositoryService service;

    @Autowired
    public ItemController(ItemRepositoryService itemRepositoryService) {
        this.service = itemRepositoryService;
    }

    @GetMapping("/add")
    public String addItemPage(Model model) {
        model.addAttribute("item", new Item());
        return "addItem";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("item") Item item) {
        service.create(item);
        return "redirect:/items/";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("items", service.findAll());
        return "listItems";
    }

    @GetMapping("/{id}")
    public String showItem(@PathVariable("id") Long id, Model model) {
        model.addAttribute("item", service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Item", "id", id)));
        return "showItem";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/items/";
    }

    @PostMapping("/search")
    public String searchItem(@RequestParam("idOrName") String idOrName, Model model) {
        model.addAttribute("items", service.findAllByName(idOrName));
        return "listItems";
    }

    @PostMapping("/{id}")
    public String updateItem(@PathVariable("id") Long id, @ModelAttribute("item") Item item) {
        service.update(id, item);
        return "redirect:/items/";
    }
}

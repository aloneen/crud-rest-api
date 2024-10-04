package org.seisen.crudrestapi.controllers;

import org.seisen.crudrestapi.entity.ItemEntity;
import org.seisen.crudrestapi.exceptions.ItemAlreadyExistsException;
import org.seisen.crudrestapi.exceptions.ItemNotFoundException;
import org.seisen.crudrestapi.models.Item;
import org.seisen.crudrestapi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping("{id}")
    public ResponseEntity getItem(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(itemService.getItemById(id));
        } catch (ItemNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping("/all-item")
    public ResponseEntity allItem() {
        try {
            return ResponseEntity.ok(itemService.getAllItems());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/create")
    public ResponseEntity createItem(@RequestBody ItemEntity item) {
        try {
            itemService.createNewItem(item);
            return ResponseEntity.ok().body("Item created");
        } catch (ItemAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }


    @PutMapping("/update")
    public ResponseEntity updateItem(@RequestBody ItemEntity item) {
        try {
            itemService.updateItem(item);
            return ResponseEntity.ok().body("Item updated");
        } catch (ItemAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        try {
            itemService.deleteItemById(id);
            return ResponseEntity.ok().body("Item deleted");
        } catch (ItemNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
}

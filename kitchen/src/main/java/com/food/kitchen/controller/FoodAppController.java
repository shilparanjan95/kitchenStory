package com.food.kitchen.controller;

import com.food.kitchen.model.*;
import com.food.kitchen.service.FoodAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/app/foodie")
public class FoodAppController {

    @Autowired
    FoodAppService foodAppService;
    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        return new  ResponseEntity(foodAppService.saveCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public List<Category> getCategoryByName()
    {
        return foodAppService.listCategory();
    }


    @PostMapping("/food")
    public ResponseEntity<Category> addFood(@RequestBody Food food)
    {
        System.out.println("food controller called");
        return new  ResponseEntity(foodAppService.saveFood(food), HttpStatus.CREATED);
    }
    @PutMapping("/food/{id}")
    public ResponseEntity<Category> updateFood(@RequestBody Food food ,@PathVariable("id") Integer id)
    {
        return new  ResponseEntity(foodAppService.updateFood(food,id), HttpStatus.OK);
    }

    @GetMapping("/food")
    public List<Food> getAllFood()
    {
        return foodAppService.listFood();
    }

    @GetMapping("/food/{category}")
    public List<Food> getAllFoodByNameAndCategory(@PathVariable("category") String category)
    {    //@shilpa : add list based on food type also
        // also ignore case while searchinig
        return foodAppService.listFoodByCategory(category);
    }

    @DeleteMapping("/food/{id}")
    public String deleteFood(@PathVariable("id") Integer id)
    {
         foodAppService.deleteFood(id);
         return "Success";
    }
    @GetMapping("/foodById/{id}")
    public Food getFood(@PathVariable("id") Integer id)
    {
          return foodAppService.findFood(id);

    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id)
    {
        return foodAppService.findCustomer(id);
    }

    @PostMapping("/customer")
    public ResponseEntity<Category> addCategory(@RequestBody Customer customer)
    {
        return new  ResponseEntity(foodAppService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/customer")
    public List<Customer> getCustomers()
    {
        return foodAppService.listCustomer();
    }

    @PostMapping("/order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order)
    {
        return new  ResponseEntity(foodAppService.saveOrder(order), HttpStatus.CREATED);
    }
    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") String id)
    {
        return new  ResponseEntity(foodAppService.getOrder(id), HttpStatus.OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> addCategory(@RequestBody Payment payment)
    {
        return new  ResponseEntity(foodAppService.savePayment(payment), HttpStatus.CREATED);
    }

}

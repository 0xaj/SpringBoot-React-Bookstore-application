package com.hexaware.bookstoremanagement.controller;

import com.hexaware.bookstoremanagement.entity.*;
import com.hexaware.bookstoremanagement.service.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cart")
public class CartController  {

    final CartService cartService;
    final BookService bookService;

    @Autowired
    public CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;

    }



    @PostMapping()
    public Map<String,String> addBook(@RequestBody Cart c) {
        HashMap<String,String> hm = new HashMap();
        System.out.println(c.getBook_id()+" "+c.getCart_id()+" "+c.getQuantity()+" "+c.getCust_id()+" "+c.getCost());
        hm.put("message","success");
        cartService.createCart(c);        System.out.println(hm);

        return hm;
    }

    @GetMapping("/cart/{cartId}")
    public Optional<Cart> getCart(@PathVariable("cartId") int id) {

        System.out.println("ffff");
        return cartService.getById(id);
    }


    @GetMapping("/{id}")
    public HashMap<String,Object> getCarts(@PathVariable("id") int id ) {

        HashMap<String,Object> hm = new HashMap<>();

        List<Cart> li = cartService.getAll(id);
        //hm.put("list", cartService.getAll(id));
        int total = 0;
        for(int i=0;i<li.size();i++){
            total += li.get(i).getCost()* li.get(i).getQuantity();
        }
        hm.put("list", cartService.getAll(id));
        hm.put("total", total);
        return hm;
    }



    @PutMapping("/cart/{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable("cartId") int id,
                                           @RequestBody Cart cart) {
        return  cartService.updateCart(id, cart);
    }

    @DeleteMapping("/{cartId}/{custId}")
    public HashMap<String,Object> removeCart(@PathVariable("cartId") int id, @PathVariable("custId") int cid )  {
        System.out.println(cid+", "+id);
        cartService.deleteCart(cid,id);
        System.out.println("deleting");
        return getCarts(id);

    }

}
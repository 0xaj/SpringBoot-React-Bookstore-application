package com.hexaware.bookstoremanagement.controller;

import com.hexaware.bookstoremanagement.entity.*;
import com.hexaware.bookstoremanagement.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin") 
public class AdminController  {

    final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{userName}/{password}", produces = "application/json")
    public Integer checkLogin(@PathVariable("userName") String name , @PathVariable("password") String pass) {


        return  adminService.checkLogin(name,pass);
    }


    @PostMapping()
    public void addUser(@RequestBody Admin admin) {
    	adminService.createAdmin(admin);
    }

    @GetMapping()
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable("id") int id) {
        return adminService.getAdmin(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id,
                                           @RequestBody Admin admin) {
        return  adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable("id") int id) {
    	adminService.deleteAdmin(id);
    }

}

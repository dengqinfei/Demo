//package com.hikvision.demo.controller;
//
//import com.hikvision.demo.model.Customer;
//import com.hikvision.demo.model.User;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping("/users")
//public class WebfluxController {
//
//    @GetMapping("/{user}")
//    public Mono<User> getUser(@PathVariable Long user) {
//        // ...
//
//    }
//
//    @GetMapping("/{user}/customers")
//    public Flux<Customer> getUserCustomers(@PathVariable Long user) {
//        // ...
//    }
//
//    @DeleteMapping("/{user}")
//    public Mono<User> deleteUser(@PathVariable Long user) {
//        // ...
//    }
//
//}

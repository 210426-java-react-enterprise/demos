package com.revature.spring_mvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    public @ResponseBody String test() {
        return "/spring-mvc-demo/test/test1 works!";
    }

    @GetMapping("/test2")
    public @ResponseBody String test2() {
        return "/spring-mvc-demo/test/test2 works!";
    }

    @GetMapping("/test3")
    public @ResponseBody String test3(@RequestParam("someValue") String someValue, @RequestParam String abc) {
        return "/spring-mvc-demo/test/test3 works! Provided values: " + someValue + " and " + abc;
    }

    @GetMapping("/test4/{whatever}/{abc}")
    public @ResponseBody String test4(@PathVariable("whatever") String anotherValue, @PathVariable String abc) {
        return "/spring-mvc-demo/test/test4 works! Provided values: " + anotherValue + " and " + abc;
    }


    @GetMapping("/home*/*")
    public @ResponseBody String test5() {
        return "Welcome home!";
    }

    @GetMapping("/test6")
    public @ResponseBody String test6(@RequestHeader("someHeader") String value) {
        return value;
    }

    @GetMapping("/test7")
    public void test7(HttpServletResponse resp) {
        System.out.println("test7 invoked!");
        System.out.println(resp);
        resp.setStatus(204); // No content response status
    }

    @GetMapping("/test8")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void test8() {
        System.out.println("test8 invoked!");
    }

    @GetMapping("/test9")
    public String test9() {
        return "index";
    }

}

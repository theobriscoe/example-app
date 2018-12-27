package com.theobriscoe.example.exampleapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;


@Controller
public class GreetingController
{

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("requestCount", counter.incrementAndGet());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        model.addAttribute("requestTime", simpleDateFormat.format(new Date()));

        return "greeting";
    }
}


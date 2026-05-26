package dev.cerez.actividad_2;

import dev.cerez.actividad_2.model.Row;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SpringBootApplication
public class Main {

    private final List<Row> rows = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PutMapping("/add")
    public void add() {

    }

    @PostMapping("/remove")
    public void remove() {

    }

}

package dev.cerez.actividad_2;

import dev.cerez.actividad_2.model.Row;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class Main {

    private final Map<Integer, Row> rows = new LinkedHashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("rows", rows);
        return "index";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam String name,
            @RequestParam String supplier,
            @RequestParam String category,
            @RequestParam String primaryLanguage,
            @RequestParam String secondaryLanguage,
            @RequestParam(required = false, defaultValue = "false") Boolean useDB,
            @RequestParam(required = false, defaultValue = "false") Boolean requiresNetwork,
            @RequestParam Integer numberOfBits,
            @RequestParam String license,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam Integer website,
            @RequestParam String email,
            @RequestParam Long installerSize
    ) {
        Row row = createRow(
                name,
                supplier,
                category,
                primaryLanguage,
                secondaryLanguage,
                useDB,
                requiresNetwork,
                numberOfBits,
                license,
                price,
                description,
                website,
                email,
                installerSize
        );
        rows.put(row.hashCode(), row);

        return "redirect:/";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam Integer key) {
        rows.remove(key);

        return "redirect:/";
    }

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<Map<Integer, Row>> get() {
        return ResponseEntity.ok(rows);
    }

    @PostMapping("/update")
    public String update(
            @RequestParam Integer key,
            @RequestParam String name,
            @RequestParam String supplier,
            @RequestParam String category,
            @RequestParam String primaryLanguage,
            @RequestParam String secondaryLanguage,
            @RequestParam(required = false, defaultValue = "false") Boolean useDB,
            @RequestParam(required = false, defaultValue = "false") Boolean requiresNetwork,
            @RequestParam Integer numberOfBits,
            @RequestParam String license,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam Integer website,
            @RequestParam String email,
            @RequestParam Long installerSize
    ) {
        Row row = createRow(
                name,
                supplier,
                category,
                primaryLanguage,
                secondaryLanguage,
                useDB,
                requiresNetwork,
                numberOfBits,
                license,
                price,
                description,
                website,
                email,
                installerSize
        );
        rows.remove(key);
        rows.put(row.hashCode(), row);

        return "redirect:/";
    }

    private Row createRow(
            String name,
            String supplier,
            String category,
            String primaryLanguage,
            String secondaryLanguage,
            Boolean useDB,
            Boolean requiresNetwork,
            Integer numberOfBits,
            String license,
            Double price,
            String description,
            Integer website,
            String email,
            Long installerSize
    ) {
        return new Row(
                name,
                supplier,
                category,
                primaryLanguage,
                secondaryLanguage,
                useDB,
                requiresNetwork,
                numberOfBits,
                license,
                price,
                description,
                website,
                email,
                installerSize
        );
    }
}

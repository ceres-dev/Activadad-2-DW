package dev.cerez.actividad_2.controller;

import dev.cerez.actividad_2.model.Row;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    private final Map<Integer, Row> rows = new LinkedHashMap<>();

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
            @RequestParam String website,
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
            @RequestParam String website,
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
            String website,
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

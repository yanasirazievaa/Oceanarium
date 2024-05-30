package com.example.turkishsite.controllers;

import com.example.turkishsite.objects.Oceanarium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private Oceanarium oceanarium;

    @GetMapping
    public String mainPage() {
        return "index";
    }

    @GetMapping("/static/{folder}/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getStaticFile(@PathVariable String folder, @PathVariable String fileName) {
        Resource file = new ClassPathResource("static/" + folder + "/" + fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/checkFish")
    public ModelAndView checkFish(@RequestParam("fishName") String fishName) {
        Map<String, Boolean> model = new HashMap<>();
        model.put("verdict", oceanarium.exists(fishName));
        return new ModelAndView("index", model);
    }

}

package com.prajakta.ProductSpringWebBitly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class URLController {
    @Autowired
    URLService service;

//    @GetMapping("/url")
//    public List<URL> getAllUrls(){
//        return service.getAllUrls();
//    }

    @PostMapping("/url")
    public URL addURL(@RequestBody String input_text){
        URL send_url_obj = service.createURLObj(input_text);
        service.addURL(send_url_obj);
//        URL send_url_obj = new URL(input_text,"awdaw");
        return send_url_obj;
    }
}

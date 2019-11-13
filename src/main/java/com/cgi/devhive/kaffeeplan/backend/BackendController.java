package com.cgi.devhive.kaffeeplan.backend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BackendController {
    @RequestMapping("/plan")
    public List<KaffeeplanEntry> getWholePlan()
    {
        List<KaffeeplanEntry> l = new ArrayList<>();
        l.add(new KaffeeplanEntry(2019, 50, "Test", "test@cgi.com"));
        return l;
    }
}

package hu.david.veres.graph.controller;

import hu.david.veres.graph.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    /*
    @RequestMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        // TODO: create normal file upload system, example in the test github repo

        storageService.store(file);

        return "test";

    }
    */

    @RequestMapping(path = "/testgraph", method = RequestMethod.GET)
    public String graphPage(){
        return "graph";
    }

}

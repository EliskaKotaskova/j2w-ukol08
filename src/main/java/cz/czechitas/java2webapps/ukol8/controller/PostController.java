package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    private final PostService service;
    
    public PostController(PostService service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public ModelAndView zakladniSeznam() {
        return new ModelAndView("posty")
                .addObject("posty", service.list());
    }
    @GetMapping("/post/{slug}")
    public ModelAndView detailPostu(@PathVariable String slug) {
        return new ModelAndView("post")
                .addObject("post", service.singlePost(slug));
    }
}
package jpabook.jpashop.web;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    @Autowired ItemService itemService;

    @RequestMapping(value = "/items/new", method = RequestMethod.GET)
    public String createForm() {
        return "items/createItemForm";
    }

    @RequestMapping(value="/items/new", method = RequestMethod.POST)
    public String processForm(Book book) {
        itemService.saveItem(book);
        return "redirect:/items";
    }
}


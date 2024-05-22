package com.practice_data_repository_1.controller;

import com.practice_data_repository_1.model.Customer;
import com.practice_data_repository_1.model.Province;
import com.practice_data_repository_1.service.interface_service.ICustomerService;
import com.practice_data_repository_1.service.interface_service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView listCustomers() {
        ModelAndView mav = new ModelAndView("customer_views/list");
        Iterable<Customer> customers = customerService.findAll();
        mav.addObject("customers", customers);
        return mav;
    }

    @GetMapping("/create_form")
    public ModelAndView createForm() {
        ModelAndView mav = new ModelAndView("customer_views/create");
        mav.addObject("customer", new Customer());
        return mav;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer created sucessfully");
        return "redirect:/customers";
    }

    @GetMapping("/update_form/{id}")
    public ModelAndView updateForm(@PathVariable("id") Integer id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView mav = new ModelAndView("customer_views/update");
            mav.addObject("customer", customer.get());
            return mav;
        } else {
            return new ModelAndView("views/error");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully");
        return "redirect:/customers";
    }
}

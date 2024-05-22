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
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;


    @GetMapping
    public ModelAndView listProvinces() {
        ModelAndView mav = new ModelAndView("province_views/list");
        Iterable<Province> provinces = provinceService.findAll();
        mav.addObject("provinces", provinces);
        return mav;
    }

    @GetMapping("/create_form")
    public ModelAndView createForm() {
        ModelAndView mav = new ModelAndView("province_views/create");
        mav.addObject("province", new Province());
        return mav;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "create new province successfully");
        return "redirect:/provinces";
    }

    @GetMapping("/update_form/{id}")
    // co can ("id") hay khong?
    public ModelAndView updateForm(@PathVariable("id") int id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView mav = new ModelAndView("province_views/update");
            mav.addObject("province", province.get());
            return mav;
        } else {
            return new ModelAndView("views/error");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "update province successfully");
        return "redirect:/provinces";
    }

    @GetMapping("/view_province/{id}")
    public ModelAndView view(@PathVariable("id") int id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            Iterable<Customer> customers = customerService.findAllByProvince(province.get());

            ModelAndView mav = new ModelAndView("customer_views/list");
            mav.addObject("customers", customers);
            return mav;
        } else {
            return new ModelAndView("views/error");
        }
    }
}

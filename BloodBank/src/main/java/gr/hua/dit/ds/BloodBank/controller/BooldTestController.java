package gr.hua.dit.ds.BloodBank.controller;

import gr.hua.dit.ds.BloodBank.entity.BloodTest;
import gr.hua.dit.ds.BloodBank.entity.Request;
import gr.hua.dit.ds.BloodBank.service.BloodTestService;
import gr.hua.dit.ds.BloodBank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bloodtest")
public class BooldTestController {

    @Autowired
    private BloodTestService bloodTestService;

    @Autowired
    private RequestService requestService;

    @PostMapping("{request_id}")
    public String saveBloodTest(@ModelAttribute("bloodtest") BloodTest bloodTest, @PathVariable("request_id") int request_id) {
        bloodTestService.saveBloodTest(bloodTest, request_id);
        return "redirect:/request/"+request_id;
    }

    @PostMapping("{request_id}/{bloodtest_id}")
    public String editBloodTest(@PathVariable int request_id, @PathVariable int bloodtest_id, Model model){
        BloodTest bloodTest = bloodTestService.getBloodTest(bloodtest_id);
        model.addAttribute("bloodtest", bloodTest);
        model.addAttribute("request_id", request_id);
        return "add_bloodtest";
    }

    /*@PostMapping("{request_id}/{bloodtest_id}")
    public String updateBloodTest(@PathVariable int request_id, @PathVariable int bloodtest_id){
        BloodTest bloodTest = bloodTestService.getBloodTest(bloodtest_id);
        Request request = requestService.getRequest(request_id);
        bloodTestService.saveBloodTest(bloodTest, request_id);
        return "redirect:/bloodtest/"+request_id;
    }*/

    @GetMapping("{request_id}")
    public String showBloodTest(@PathVariable("request_id") int request_id, Model model){
        Request request = requestService.getRequest(request_id);
        BloodTest bloodTest = request.getBloodTest();
        model.addAttribute("bloodtest", bloodTest);
        model.addAttribute("request", request);
        return "bloodtest";
    }

    @GetMapping("{request_id}/new")
    public String addBloodTest(@PathVariable("request_id") int request_id, Model model){
        BloodTest bloodTest = new BloodTest();
        model.addAttribute("bloodtest", bloodTest);
        model.addAttribute("request_id", request_id);
        return "add_bloodtest";
    }

}
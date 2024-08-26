package gr.hua.dit.ds.BloodBank.controller;

import gr.hua.dit.ds.BloodBank.entity.Request;
import gr.hua.dit.ds.BloodBank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("")
    public String showRequests(Model model){
        model.addAttribute("requests", requestService.getRequests());
        return "requests";
    }

    @GetMapping("/new")
    public String addRequest(Model model){
        Request request = new Request();
        model.addAttribute("request", request);
        return "add_request";
    }

    @GetMapping("{request_id}")
    public String editRequest(@PathVariable Integer request_id, Model model){
        Request request = requestService.getRequest(request_id);
        model.addAttribute("request", request);
        return "add_request";
    }

    @PostMapping("/new")
    public String saveRequest(Request request, Model model){
        requestService.saveRequest(request);
        model.addAttribute("requests", requestService.getRequests());
        return "requests";
    }


    @DeleteMapping("{request_id}")
    public String deleteRequest(@PathVariable Integer request_id){
        requestService.deleteRequest(request_id);
        return "requests";
    }



}

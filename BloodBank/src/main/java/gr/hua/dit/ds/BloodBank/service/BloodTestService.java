package gr.hua.dit.ds.BloodBank.service;

import gr.hua.dit.ds.BloodBank.entity.BloodTest;
import gr.hua.dit.ds.BloodBank.entity.Request;
import gr.hua.dit.ds.BloodBank.repository.BloodTestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodTestService {

    @Autowired
    private BloodTestRepository bloodTestRepository;

    @Autowired
    private RequestService requestService;

    @Transactional
    public void saveBloodTest(BloodTest bloodTest, int request_id) {
        Request request = requestService.getRequest(request_id);
        bloodTest.setRequest(request);
        bloodTestRepository.save(bloodTest);
    }

    @Transactional
    public BloodTest getBloodTest(int id) {
        return bloodTestRepository.findById(id).get();
    }




}
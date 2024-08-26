package gr.hua.dit.ds.BloodBank.service;

import gr.hua.dit.ds.BloodBank.entity.Request;
import gr.hua.dit.ds.BloodBank.repository.RequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Transactional
    public List<Request> getRequests(){
        return requestRepository.findAll();
    }

    @Transactional
    public void saveRequest(Request request){
        requestRepository.save(request);
    }

    @Transactional
    public void deleteRequest(Integer requestId) {
        requestRepository.deleteById(requestId);
    }

    @Transactional
    public Request getRequest(Integer requestId) {
        return requestRepository.findById(requestId).get();
    }

}

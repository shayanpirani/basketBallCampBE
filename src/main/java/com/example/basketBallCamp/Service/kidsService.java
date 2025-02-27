package com.example.basketBallCamp.Service;

import com.example.basketBallCamp.Entity.kids;
import com.example.basketBallCamp.Model.kidsModel;
import com.example.basketBallCamp.Repository.kidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class kidsService {

    @Autowired
    private kidsRepository kidsRepository;

    public List<kids> getAllKids() {
        return kidsRepository.findAll();
    }

    public Long addKid(kids kid) {
        kids savedKid = kidsRepository.save(kid);
        return savedKid.getKidId();
    }
    public boolean existsBykidEmail(String email) {
        return kidsRepository.existsBykidEmail(email);
    }

    public kids getKid(Long id)
    {
        return kidsRepository.findById(id).get();
    }

}

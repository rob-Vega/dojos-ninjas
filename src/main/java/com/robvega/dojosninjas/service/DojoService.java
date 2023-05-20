package com.robvega.dojosninjas.service;

import com.robvega.dojosninjas.model.Dojo;
import com.robvega.dojosninjas.repository.DojoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> findAll() {
        return dojoRepository.findAll();
    }

    public void create(Dojo dojo) {
        dojoRepository.save(dojo);
    }

    public Dojo findById(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) return optionalDojo.get();
        return null;
    }
}

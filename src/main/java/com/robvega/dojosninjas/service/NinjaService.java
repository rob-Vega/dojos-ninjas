package com.robvega.dojosninjas.service;

import com.robvega.dojosninjas.model.Ninja;
import com.robvega.dojosninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public void create(Ninja ninja) {
        ninjaRepository.save(ninja);
    }
}

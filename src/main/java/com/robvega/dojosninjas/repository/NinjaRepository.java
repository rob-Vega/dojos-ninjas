package com.robvega.dojosninjas.repository;

import com.robvega.dojosninjas.model.Ninja;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
}

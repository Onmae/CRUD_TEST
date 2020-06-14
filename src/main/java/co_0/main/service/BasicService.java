package com0.main.service;

import com0.main.domain.Basic;
import com0.main.repository.BasicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {
    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public List<Basic> findBasicList() {
        return basicRepository.findAll();
    }
    public Basic findBasicByIdx(Long idx) {
        return basicRepository.findById(idx).orElse(new Basic());
    }

    public Basic newBasic(Basic basic) {
       return basicRepository.save(basic);

    }
}

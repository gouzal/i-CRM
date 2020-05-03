package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.entity.SaleItem;
import com.gouzal.icrm.repository.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItemService implements Operation<SaleItem> {

    @Autowired
    SaleItemRepository saleItemRepository;

    public List<SaleItem> findAll() {
        return saleItemRepository.findAll();
    }

    public Optional<SaleItem> findById(Long id) {
        return saleItemRepository.findById(id);
    }

    public void save(SaleItem SaleItem) {
        saleItemRepository.save(SaleItem);
    }

    public void deleteById(Long id) {
        saleItemRepository.deleteById(id);
    }

}

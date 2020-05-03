package com.gouzal.icrm.service;

import java.util.List;
import java.util.Optional;

import com.gouzal.icrm.entity.PurchaseItem;
import com.gouzal.icrm.repository.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseItemService implements Operation<PurchaseItem> {

    @Autowired
    PurchaseItemRepository purchaseItemRepository;

    public List<PurchaseItem> findAll() {
        return purchaseItemRepository.findAll();
    }

    public Optional<PurchaseItem> findById(Long id) {
        return purchaseItemRepository.findById(id);
    }

    public void save(PurchaseItem article) {
        purchaseItemRepository.save(article);
    }

    public void deleteById(Long id) {
        purchaseItemRepository.deleteById(id);
    }


}

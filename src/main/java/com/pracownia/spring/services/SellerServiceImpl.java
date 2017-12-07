package com.pracownia.spring.services;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.entities.Seller;
import com.pracownia.spring.repositories.ProductRepository;
import com.pracownia.spring.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Iterable<Seller> listAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getSellerById(Integer id) {
        return sellerRepository.findOne(id);
    }

    @Override
    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public void deleteSeller(Integer id) {
        sellerRepository.delete(id);
    }
}

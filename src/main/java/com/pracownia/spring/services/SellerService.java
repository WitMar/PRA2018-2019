package com.pracownia.spring.services;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.entities.Seller;

public interface SellerService {

    Iterable<Seller> listAllSellers();

    Seller getSellerById(Integer id);

    Seller saveSeller(Seller seller);

    void deleteSeller(Integer id);

}

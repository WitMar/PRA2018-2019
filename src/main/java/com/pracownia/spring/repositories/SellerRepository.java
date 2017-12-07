package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.entities.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Integer> {

}

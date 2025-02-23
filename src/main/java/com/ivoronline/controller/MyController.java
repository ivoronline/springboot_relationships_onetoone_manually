package com.ivoronline.controller;

import com.ivoronline.entity.Address;
import com.ivoronline.entity.Author;
import com.ivoronline.repository.AddressRepository;
import com.ivoronline.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired AddressRepository addressRepository;
  @Autowired AuthorRepository  authorRepository;

  //===========================================================================
  // ADD ADDRESS
  //===========================================================================
  @RequestMapping("AddAddress")
  String addAddress() {

    //CREATE ADDRESS
    Address address        = new Address();
            address.city   = "London";
            address.street = "Piccadilly";

    //SAVE ADDRESS
    addressRepository.save(address);

    //RETURN MESSAGE
    return "ADDRESS.ID = " + address.id;

  }
  
  //===========================================================================
  // ADD AUTHOR
  //===========================================================================
  @RequestMapping("AddAuthor")
  String addAuthor() {
  
    //CREATE ADDRESS
    Address address        = new Address();
            address.city   = "New York";
            address.street = "Pearl Street";

    //CREATE AUTHOR
    Author  author           = new Author();
            author.name      = "John";
            author.age       = 20;
            author.address   = address;
            author.addressId = 1;
            
    //STORE AUTHOR INTO DB
    authorRepository.save(author);
    
    //CHANGE TO NEW YORK ADDRESS BY MANUALLY SETTING addressId AFTER ADDRESS WAS SAVED THROUGH AUTHOR
    //author.addressId = author.address.id;
    //authorRepository.save(author);

    //RETURN MESSAGE
    return "Author was stored into DB";

  }

  //===========================================================================
  // GET AUTHOR ADDRESS
  //===========================================================================
  @RequestMapping("GetAuthorAddress")
  String getAuthorAddress() {

    //GET AUTHOR
    Author author = authorRepository.findById(1).get();

    //RETURN MESSAGE
    return author.name + " lives in " + author.address.city;
    
  }

}

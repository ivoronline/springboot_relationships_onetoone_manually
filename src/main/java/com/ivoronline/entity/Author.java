package com.ivoronline.entity;

import javax.persistence.*;

@Entity
public class Author {

  //DATA
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;
  public Integer addressId;                                              //Manually control FK
  
  //RELATIONSHIPS
  @OneToOne(cascade = CascadeType.ALL)                                   //Children can still be saved
  @JoinColumn(name = "addressId", insertable = false, updatable = false) //FK is not automatically set
  public Address address;

}






package com.bf.service;

import org.springframework.stereotype.Service;

import com.bf.base.AbstractBaseDao;
import com.bf.entity.Product;
@Service
public class ProductServiceImpl extends AbstractBaseDao<Product, Integer> implements ProductService {

}

package com.tensquare.search.dao;

import com.tensquare.search.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductSearchDao extends ElasticsearchRepository<Product,String> {

    /*Page<Product> findByTitleOrContentLike(String title, String content, Pageable pageable);*/


    Page<Product> findByMCnameOrHNameLike(String title, String content, Pageable pageable);


}

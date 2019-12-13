package com.tensquare.search.service;

import com.tensquare.search.dao.ProductSearchDao;
import com.tensquare.search.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

@Service
public class ProductSearchService {

    @Autowired
    private ProductSearchDao productSearchDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存索引
     *
     * @param product
     */
    public void save(Product product) {
        product.setId(idWorker.nextId() + "");
        productSearchDao.save(product);
    }

    /**
     * 搜索文章
     * @param key
     * @param page
     * @param size
     * @return
     */
    public Page<Product> findByKey(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return productSearchDao.findByMCnameOrHNameLike(key, key, pageable);
    }
}

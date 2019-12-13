package com.tensquare.search.controller;

import com.tensquare.search.pojo.Product;
import com.tensquare.search.service.ProductSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductSearchController {


    @Autowired
    private ProductSearchService productSearchService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Product product) {
        productSearchService.save(product);
        return new Result(true, StatusCode.OK, "操作成功");
    }

    @RequestMapping(value = "/{key}/{page}/{size}", method = RequestMethod.GET)
    public Result findByKey(@PathVariable String key, @PathVariable int page, @PathVariable int size) {
        Page<Product> pageDtat = productSearchService.findByKey(key, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Product>(pageDtat.getTotalElements(), pageDtat.getContent()));
    }
}

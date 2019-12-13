package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelSerives;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签业务实现
 * @ Author        :  huqingsong
 * @ CreateDate    :  2019-09-12 14:29
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/label")
public class LabelController {

    @Autowired
    private LabelSerives labelSerives;

    /**
     * 查询全部标签
     *
     * @return 全部标签对象
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", labelSerives.findAll());
    }

    /**
     * 根据id查标签
     *
     * @param labelId 标签id
     * @return 标签对象
     */
    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId) {
        return new Result(true, StatusCode.OK, "查询成功", labelSerives.findById(labelId));
    }

    /**
     * 新增标签保存
     *
     * @param label 新增标签信息
     * @return 保存成功状态
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelSerives.save(label);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    /**
     * 修改标签保存
     *
     * @param labelId 标签id
     * @param label   传入的内容
     * @return 修改成功状态
     */
    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label) {
        labelSerives.findById(labelId);
        labelSerives.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除标签
     *
     * @param labelId 标签id
     * @return 修改成功状态
     */
    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId) {
        labelSerives.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 条件搜索标签
     *
     * @param label 搜索条件
     * @return 搜索结果
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> labels = labelSerives.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功", labels);
    }

    /**
     * 分页查询标签
     *
     * @param label 查询条件
     * @param page  分页
     * @param size  条数
     * @return 查询结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label, @PathVariable int page, @PathVariable int size) {
        Page<Label> labels = labelSerives.pageQuery(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Label>(labels.getTotalElements(), labels.getContent()));
    }
}

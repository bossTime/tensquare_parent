package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 标签service
 *
 * @ Author        :  huqingsong
 * @ CreateDate    :  2019-09-12 10:57
 */
@Service
@Transactional
public class LabelSerives {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有
     *
     * @return Label
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 根据id查询
     *
     * @param id 标签id
     * @return label对象
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 保存标签
     *
     * @param label 标签对象
     */
    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 更新标签
     *
     * @param label 修改内容
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除标签
     *
     * @param id 标签id
     */
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 标签搜索
     *
     * @param label 搜索内容
     * @return 处理结果
     */
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象 也就是要把条件封装到那个对象中。where类名=label.getid
             * @param criteriaQuery 封装的都是查询关键字，比如group by  order by 等
             * @param criteriaBuilder 用来封装的条件对象，如果直接返回null 则表示
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> objects = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    objects.add(predicate);
                }
                if (label.getState()!=null && !"".equals(label.getState())){
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    objects.add(predicate);
                }
                Predicate[] predicates = new Predicate[objects.size()];
                predicates = objects.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        });
    }

    /**
     * 分页查询标签
     * @param label 查询条件
     * @param page 分页
     * @param size 条数
     * @return 查询结果
     */
    public Page<Label> pageQuery(Label label, int page, int size) {

        Pageable pageQuery = PageRequest.of(page-1,size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象 也就是要把条件封装到那个对象中。where类名=label.getid
             * @param criteriaQuery 封装的都是查询关键字，比如group by  order by 等
             * @param criteriaBuilder 用来封装的条件对象，如果直接返回null 则表示
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> objects = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    objects.add(predicate);
                }
                if (label.getState()!=null && !"".equals(label.getState())){
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    objects.add(predicate);
                }
                Predicate[] predicates = new Predicate[objects.size()];
                predicates = objects.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        },pageQuery);
    }
}

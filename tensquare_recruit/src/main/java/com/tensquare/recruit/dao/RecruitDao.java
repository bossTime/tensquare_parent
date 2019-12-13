package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
    /**
     * 热门职位
     *
     * @param state
     * @return
     */
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

    /**
     * 热门职位并且是开启状态
     *
     * @param state
     * @return
     */
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);

}

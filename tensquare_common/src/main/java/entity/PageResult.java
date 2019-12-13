package entity;

import org.apache.catalina.LifecycleState;

import java.io.Serializable;
import java.util.List;

/**
 * 分页公共类
 *
 * @ Author        :  huqingsong
 * @ CreateDate    :  2019-09-12 9:41
 */
public class PageResult<T> implements Serializable {

    private long total;

    private List<T> rows;

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult(long totalElements, int totalPages) {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

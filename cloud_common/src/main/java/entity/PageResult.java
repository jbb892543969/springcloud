package entity;

import java.util.List;

/**
 * 分页结果集
 *
 * @author jbb
 * @date 2019/3/16
 */
public class PageResult<T> {
    /** 总记录数 */
    private Long total;
    /** 分页后行数 */
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {}

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

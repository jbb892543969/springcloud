package com.jbb.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * 标签实体
 *
 * @author jbb
 * @date 2019/3/16
 */
@Entity
@Table(name = "tb_label", schema = "tensquare_base", catalog = "")
public class Label {
    private String id;
    private String labelname;
    private String state;
    private Long count;
    private String recommend;
    private Long fans;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "labelname")
    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "count")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Basic
    @Column(name = "recommend")
    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    @Basic
    @Column(name = "fans")
    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(id, label.id) &&
                Objects.equals(labelname, label.labelname) &&
                Objects.equals(state, label.state) &&
                Objects.equals(count, label.count) &&
                Objects.equals(recommend, label.recommend) &&
                Objects.equals(fans, label.fans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, labelname, state, count, recommend, fans);
    }
}

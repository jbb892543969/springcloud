package com.jbb.base.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 城市实体
 *
 * @author jbb
 * @date 2019/3/16
 */
@Entity
@Table(name = "tb_city", schema = "tensquare_base", catalog = "")
public class City implements Serializable {
    private String id;
    private String name;
    private String ishot;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ishot")
    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(ishot, city.ishot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ishot);
    }
}

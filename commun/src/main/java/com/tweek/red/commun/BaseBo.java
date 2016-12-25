package com.tweek.red.commun;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tweek on 25/12/16.
 */
public class BaseBo {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseBo baseBo = (BaseBo) o;

        return id.equals(baseBo.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

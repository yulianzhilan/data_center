package cn.janescott.domain;

import cn.janescott.common.Constants;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by scott on 2017/9/5.
 */
@Entity
@Table(name = "CONFIG", schema = Constants.DATA_CENTER_SCHEMA)
public class ConfigEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String category;

    private String name;

    private String key;

    private Date modify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getModify() {
        return modify;
    }

    public void setModify(Date modify) {
        this.modify = modify;
    }
}

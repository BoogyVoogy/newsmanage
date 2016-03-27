package net.news.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Bugarchev A.A. on 2016.
 */
@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "cname")
    private String cname;

    public Integer getId(){return id;}

    public void setId(Integer id){this.id=id;}

    public String getCname(){return cname;}

    public void setCname(String cname){this.cname=cname;}

}

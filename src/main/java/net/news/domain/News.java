package net.news.domain;

import net.news.service.CategoryService;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bugarchev A.A. on 2016.
 */
@Entity
@Table(name="news")
public class News {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "descr")
    private String descr;

    @Column(name = "date")

    private Date date;

    @Column(name = "c_id")
    private Integer c_id;

    public Integer getId(){return id;}

    public void setId(Integer id){this.id=id;}

    public Integer getC_id(){return c_id;}

    public void setC_id(Integer c_id){this.c_id=c_id;}

    public String getTitle(){return title;}

    public void setTitle(String title){this.title=title;}

    public String getDescr(){return descr;}

    public void setDescr(String descr){this.descr=descr;}

    public Date getDate(){return date;}

    public String getSimpleDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyг");
        return sdf.format(date);
    }



    public void setDate(Date date){this.date=date;}
}

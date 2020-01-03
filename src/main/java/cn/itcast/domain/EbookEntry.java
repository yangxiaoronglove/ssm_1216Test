package cn.itcast.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author caoqian
 * @Date 2019/12/16 8:21
 * @Version 1.0
 */
//电子图书表
public class EbookEntry implements Serializable {
    private Integer id;//图书编号
    private Integer categoryId;//分类编号
    private String title;//图书名称
    private String summary;//摘要
    private String uploaduser;//上传人
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;//上传时间

    public EbookEntry(Integer id, Integer categoryId, String title, String summary, String uploaduser, Date createdate) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.summary = summary;
        this.uploaduser = uploaduser;
        this.createdate = createdate;
    }

    public EbookEntry() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "EbookEntry{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", uploaduser='" + uploaduser + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}

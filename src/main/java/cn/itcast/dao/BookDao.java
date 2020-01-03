package cn.itcast.dao;

import cn.itcast.domain.EbookCategory;
import cn.itcast.domain.EbookEntry;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author caoqian
 * @Date 2019/12/16 8:29
 * @Version 1.0
 */
@Repository
public interface BookDao {

    /**
     * 查询所有图书类别
     * @return
     */
    @Select("SELECT * FROM ebook_category")
    List<EbookCategory> findAll();

    /**
     * 动态查询
     * @param searchName
     * @return
     */
    @Select("<script>"+
            "SELECT * FROM ebook_entry  "+
            "<where>"+

            "<if test='searchName!=null &amp; searchName!=&quot;&quot; '>"+
            " AND categoryId=#{searchName} "+
            "</if>"+


            "</where>"+
            "</script>"
    )
    List<EbookEntry> findByCondition(@Param(value = "searchName") String searchName);

    /**
     * 添加图书
     * @param ebookEntry
     */
    @Insert("INSERT INTO ebook_entry VALUES(NULL,1001,#{title},#{summary},#{uploaduser},#{createdate})")
    void add(EbookEntry ebookEntry);

    /**
     * 根据id查询图书信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM ebook_entry WHERE id =#{id}")
    EbookEntry findByID(@Param(value = "id") Integer id);

    /**
     * 修改图书信息
     * @param ebookEntry
     */
    @Update("UPDATE ebook_entry SET title=#{title},summary=#{summary},uploaduser=#{uploaduser},createdate=#{createdate}\n" +
            "WHERE id =#{id}")
    void update(EbookEntry ebookEntry);

    /**
     * 根据id删除
     * @param id
     */
    @Delete("DELETE FROM ebook_entry WHERE id = #{id}")
    void DelById(@Param(value = "id") Integer id);
}

package cn.itcast.service;

import cn.itcast.domain.EbookCategory;
import cn.itcast.domain.EbookEntry;

import java.util.List;

/**
 * @Author caoqian
 * @Date 2019/12/16 8:28
 * @Version 1.0
 */
public interface BookService {

    /**
     * 查询图书类别
     * @return
     */
    List<EbookCategory> findCategory() throws Exception;

    /**
     * 动态查询
     * @param searchName
     * @param page
     * @param size
     * @return
     */
    List<EbookEntry> findByCondition(String searchName, Integer page, Integer size);

    /**
     * 添加图书信息
     * @param ebookEntry
     */
    void addBook(EbookEntry ebookEntry);

    /**
     * 根据id查询图书信息
     * @param id
     * @return
     */
    EbookEntry findById(Integer id);

    /**
     * 修改图书信息
     * @param ebookEntry
     */
    void update(EbookEntry ebookEntry);

    /**
     * 删除图书信息
     * @param id
     */
    void delById(Integer id);

}

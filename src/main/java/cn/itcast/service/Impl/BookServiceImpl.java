package cn.itcast.service.Impl;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.EbookCategory;
import cn.itcast.domain.EbookEntry;
import cn.itcast.service.BookService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author caoqian
 * @Date 2019/12/16 8:29
 * @Version 1.0
 */
@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 查询图书分类
     * @return
     * @throws Exception
     */
    @Override
    public List<EbookCategory> findCategory() throws Exception {
        return bookDao.findAll();
    }

    /**
     * 动态查询
     * @param searchName
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<EbookEntry> findByCondition(String searchName, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return bookDao.findByCondition(searchName);
    }

    /**
     * 添加图书
     * @param ebookEntry
     */
    @Override
    public void addBook(EbookEntry ebookEntry) {
        bookDao.add(ebookEntry);
    }

    /**
     * 根据图书id查询图书
     * @param id
     * @return
     */
    @Override
    public EbookEntry findById(Integer id) {
        return bookDao.findByID(id);
    }

    /**
     * 修改图书信息
     * @param ebookEntry
     */
    @Override
    public void update(EbookEntry ebookEntry) {
        bookDao.update(ebookEntry);
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void delById(Integer id) {
        bookDao.DelById(id);
    }
}

package cn.itcast.web;

import cn.itcast.domain.EbookCategory;
import cn.itcast.domain.EbookEntry;
import cn.itcast.service.BookService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author caoqian
 * @Date 2019/12/16 8:23
 * @Version 1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 动态查询
     * @param page
     * @param size
     * @param searchName
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findByCondition(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = true, defaultValue = "4") Integer size,
            String searchName

    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //查询所有图书类别
        List<EbookCategory> ebookCategoryList=bookService.findCategory();
        modelAndView.addObject("ebookCategoryList",ebookCategoryList);
        //分页展示数据
        List<EbookEntry> entryList=bookService.findByCondition(searchName,page,size);
        PageInfo<EbookEntry> pageInfo=new PageInfo<>(entryList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("list");
        return modelAndView;
    }


    /**
     * 跳转至添加界面
     * @return
     */
    @RequestMapping("goAdd.do")
    public String goAdd(){
        return "add";
    }

    /**
     * 添加图书信息
     * @param ebookEntry
     * @return
     */
    @RequestMapping("add.do")
    public ModelAndView addBook(EbookEntry ebookEntry){
        ModelAndView modelAndView = new ModelAndView();
        bookService.addBook(ebookEntry);
        modelAndView.setViewName("forward:findAll.do");
        return modelAndView;
    }

    /**
     * 去修改页面
     * @return
     */
    @RequestMapping("/goUpdate")
    public ModelAndView goUpdate(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        EbookEntry entryList=bookService.findById(id);
        modelAndView.addObject("id",id);
        modelAndView.addObject("entryList",entryList);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    /**
     * 根据图书id修改图书
     * @param id
     * @param ebookEntry
     * @return
     */
    @RequestMapping("/update.do")
    public ModelAndView updateBook(Integer id,EbookEntry ebookEntry){
        ModelAndView modelAndView = new ModelAndView();
        ebookEntry.setId(id);
        bookService.update(ebookEntry);
        modelAndView.setViewName("forward:findAll.do");
        return modelAndView;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/del.do")
    public ModelAndView delBook(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        bookService.delById(id);
        modelAndView.setViewName("forward:findAll.do");
        return modelAndView;
    }
}

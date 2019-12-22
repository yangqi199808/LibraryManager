package com.yangqi.controller;

import com.yangqi.dao.BookTypeDAO;
import com.yangqi.model.BookTypeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoer
 * @date 2019/12/21 15:40
 */
@Controller
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookTypeController {
    private BookTypeDAO bookTypeDAO;

    @Resource
    public void setBookTypeDAO(BookTypeDAO bookTypeDAO) {
        this.bookTypeDAO = bookTypeDAO;
    }

    /**
     * 添加一条书籍类型记录
     *
     * @param bookType 书籍类型编号
     * @param typeName 书籍类型名称
     * @return 结果
     */
    @RequestMapping(value = "/addBookType")
    @ResponseBody
    public Map<String, String> add(Integer bookType, String typeName) {
        Map<String, String> res = new HashMap<>();
        BookTypeEntity bookTypeEntity = new BookTypeEntity();
        bookTypeEntity.setBookType(bookType);
        bookTypeEntity.setBookName(typeName);

        bookTypeDAO.save(bookTypeEntity);
        res.put("result", "SUCCESS");
        return res;
    }

    /**
     * 删除一条书籍类型记录
     *
     * @param bookType 书籍类型编号
     * @return 页面
     */
    @RequestMapping(value = "/")
    public String delete(@PathVariable("id") Integer bookType) {
        bookTypeDAO.delete(bookTypeDAO.findById(bookType));
        return "/";
    }
}

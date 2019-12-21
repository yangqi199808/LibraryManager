package com.yangqi.controller;

import com.yangqi.dao.BookDAO;
import com.yangqi.model.BookEntity;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/3.
 * 控制层
 */
@Controller
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookController {
    private BookDAO bookDAO;

    @Resource
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    private static String textParser(String source) {
        if (source == null) {
            return "";
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            switch (c) {
                case '<':
                    buffer.append("&lt;");
                    break;
                case '>':
                    buffer.append("&gt;");
                    break;
                case '&':
                    buffer.append("&amp;");
                    break;
                case '"':
                    buffer.append("&quot;");
                    break;
                case '\n':
                    buffer.append("<br/>");
                    break;
                default:
                    buffer.append(c);
            }
        }
        return buffer.toString();
    }

    @RequestMapping(value = "/addBook")
    @ResponseBody
    public Map<String, String> add(String bookId, String bookName, String bookAuthor, String bookTranslator,
                                   String bookPublish, Integer bookNum, Integer bookType, Timestamp bookRecord) throws Exception {
        Map<String, String> res = new HashMap<>();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(bookId);
        bookEntity.setBookName(bookName);
        bookEntity.setBookAuthor(bookAuthor);
        bookEntity.setBookTranslator(bookTranslator);
        bookEntity.setBookPublish(bookPublish);
        bookEntity.setBookNum(bookNum);
        bookEntity.setBookType(bookType);
        bookEntity.setBookRecord(bookRecord);

        bookDAO.save(bookEntity);
        res.put("result", "SUCCESS");
        return res;
    }

    /**
     * 展示书籍ISBN=id的书籍
     *
     * @param bookId 根据id查询
     * @param modelMap
     * @return 页面
     * @throws Exception
     */
    @RequestMapping(value = "/show/{id}")
    public String get(@PathVariable("id") String bookId, ModelMap modelMap) throws Exception {
        modelMap.addAttribute("book", bookDAO.findByID(bookId));
        return "book";
    }

    /**
     * 转到update的目录
     *
     * @param bookId 根据id返回
     * @return 页面
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}")
    public String toUpdatePage(@PathVariable("id") String bookId, ModelMap modelMap) throws Exception {
        modelMap.addAttribute("book", bookDAO.findByID(bookId));
        return "bookUpdate";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map<String, String> update(@RequestBody BookEntity book) throws Exception {
        Map<String, String> res = new HashMap<>();
        bookDAO.save(book);
        res.put("result", "SUCCESS");
        return res;
    }

    /**
     * 删除一条记录
     *
     * @param bookId 根据id删除
     * @return 页面
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") String bookId) throws Exception {
        bookDAO.delete(bookDAO.findByID(bookId));
        return "index";
    }

}
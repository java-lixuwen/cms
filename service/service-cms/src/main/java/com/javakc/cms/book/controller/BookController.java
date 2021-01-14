package com.javakc.cms.book.controller;

import com.javakc.cms.book.entity.Book;

import com.javakc.cms.book.service.BookService;
import com.javakc.cms.book.vo.BookQuery;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: javakc-parent
 * @description: 书籍管理 - 控制器
 * @author: Li xuwen
 * @create: 2021-01-11 20:17
 **/
@Api(tags = "书籍管理")
@RestController
@RequestMapping("/cms/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "查询所有书籍")
    @GetMapping
    public APICODE findAll(){
        //制造异常
        //int i = 1/0;
        // 调用 service 的查询方法
        List<Book> list = bookService.findAll();
        return APICODE.OK().data("items",list);
    }

    @ApiOperation("根据条件进行分页查询 - 书籍管理")
    @PostMapping("{pageNo}/{pageSize}")
     public APICODE pageBook(@RequestBody(required = false) BookQuery bookQuery, @PathVariable Integer pageNo, @PathVariable Integer pageSize){
        /// 调用 service 中的分页查询方法
        Page<Book> page = bookService.pagebook(bookQuery,pageNo,pageSize);
        long totalElements =page.getTotalElements();
        List<Book> list = page.getContent();
        return APICODE.OK().data("total",totalElements).data("items",list);
    }

    @ApiOperation("添加书籍")
    @PostMapping("saveBook")
    public APICODE saveBook(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }

    @ApiOperation("根据传入的 ID 值删除书籍")
    @DeleteMapping("{bookId}")
    public APICODE deleteBook(String bookId){
        bookService.removeById(bookId);
        return APICODE.OK();
    }
    @ApiOperation("根据传入的 ID 获取单条数据 - 书籍信息")
    @GetMapping("{bookId}")
    public APICODE view(String bookId){
        Book book = bookService.getById(bookId);
        return APICODE.OK().data("book",book);
    }

    @ApiOperation("修改书籍")
    @PostMapping("updateBook")
    public APICODE updateBook(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }
}

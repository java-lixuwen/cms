package com.javakc.cms.book.service;

import com.javakc.cms.book.dao.BookDao;
import com.javakc.cms.book.entity.Book;
import com.javakc.cms.book.vo.BookQuery;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: javakc-parent
 * @description: 书籍管理 - 逻辑层
 * @author: Li xuwen
 * @create: 2021-01-11 20:18
 **/
@Service
public class BookService extends BaseService<BookDao,Book> {

    @Autowired
    private BookDao bookDao;

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<Book> findAll() {
        //调用 dao 方法进行查询
        List<Book> list = bookDao.findAll();
        return list;
    }

//    /**
//     * 根据条件进行分页查询
//     *
//     * @param bookQuery
//     * @param pageNo
//     * @param pageSize
//     * @return
//     */
//       public Page<Book> findPageBook(BookQuery bookQuery, int pageNo , int pageSize) {
//        /**
//         * 可用操作符
//         * = 等值、!= 不等值 (字符串、数字)
//         * >=、<=、>、< (数字)
//         * ge，le，gt，lt(字符串)
//         * :表示like %v%
//         * l:表示 v%
//         * :l表示 %v
//         * null表示 is null
//         * !null表示 is not null
//         */
//        Specification<Book> specification = new SimpleSpecificationBuilder().and("title", ":", bookQuery.getTitle()).getSpecification();
//        return dao.findAll(specification, PageRequest.of(pageNo - 1, pageSize));
//    }

//}

    /**
     * 根据条件进行分页查询
     * @param bookQuery
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> pagebook(BookQuery bookQuery, Integer pageNo, Integer pageSize) {
        /**
         * 可用操作符
         * = 等值、!= 不等值 (字符串、数字)
         * >=、<=、>、< (数字)
         * ge，le，gt，lt(字符串)
         * :表示like %v%
         * l:表示 v%
         * :l表示 %v
         * null表示 is null
         * !null表示 is not null
         */
        SimpleSpecificationBuilder<Book> simpleSpecificationBuilder = new SimpleSpecificationBuilder<>();
        if (!StringUtils.isEmpty(bookQuery.getBookName())) {
            simpleSpecificationBuilder.and("bookName", ":", bookQuery.getBookName());
        }
        if (!StringUtils.isEmpty(bookQuery.getBeginDate())){
            simpleSpecificationBuilder.and("startTime","ge",bookQuery.getBeginDate());
        }
        if (!StringUtils.isEmpty(bookQuery.getEndDate())){
            simpleSpecificationBuilder.and("startTime","lt",bookQuery.getEndDate());
        }
        Page page = bookDao.findAll(simpleSpecificationBuilder.getSpecification(), PageRequest.of(pageNo - 1, pageSize));
        return page;

    }
}
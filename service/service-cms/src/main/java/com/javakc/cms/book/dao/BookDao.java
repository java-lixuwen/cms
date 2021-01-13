package com.javakc.cms.book.dao;

import com.javakc.cms.book.entity.Book;
import com.javakc.commonutils.jpa.base.dao.BaseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @program: javakc-parent
 * @description: 书籍管理 - 数据控制层
 * @author: Li xuwen
 * @create: 2021-01-11 20:17
 **/
public interface BookDao extends BaseDao<Book,String> {
}

package com.javakc.cms.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: javakc-parent
 * @description:
 * @author: Li xuwen
 * @create: 2021-01-11 20:18
 **/
@Getter
@Setter
@Entity
@Table(name = "cms_book")
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "generator_uuid")
    @GenericGenerator(name = "generator_uuid", strategy = "uuid")
    @ApiModelProperty(value = "书籍主键,采用hibernate的uuid生成32位字符串")
    private String id;

    @Column(name = "book_name")
    @ApiModelProperty(value = "书名")
    private String bookName;

    @Column(name = "author")
    @ApiModelProperty(value = "作者")
    private String author;

    @Column(name = "first_sort")
    @ApiModelProperty(value = "一级分类")
    private String firstSort ;

    @Column(name = "second_sort")
    @ApiModelProperty(value = "二级分类")
    private String secondSort;

    @Column(name = "is_serialize")
    @ApiModelProperty(value = "是否连载 1是 0否")
    private int serialize;

    @Column(name = "word_number")
    @ApiModelProperty(value = "总字数")
    private int wordNumber;

    @Column(name = "is_status")
    @ApiModelProperty(value = "是否上线 1是 0否")
    private int status;

    @Column(name = "is_free")
    @ApiModelProperty(value = "全本收费 1是 0否")
    private int free;

    @Column(name = "start_time")
    @ApiModelProperty(value = "授权开始时间")
    private String startTime;

    @Column(name = "end_time")
    @ApiModelProperty(value = "授权结束时间")
    private String endTime;

    @Column(name = "is_original")
    @ApiModelProperty(value = "是否原创 1是 0否")
    private int original;


    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
    @Column(name = "gmt_create",nullable = false,updatable = false)
    @ApiModelProperty(value = "创建时间", example = "2020-12-12 9:00:00")
    private Date gmtCreate;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
    @Column(name = "gmt_modified",nullable = false,insertable = false)
    @ApiModelProperty(value = "更新时间", example = "2020-12-12 9:00:00")
    private Date gmtModified;
}

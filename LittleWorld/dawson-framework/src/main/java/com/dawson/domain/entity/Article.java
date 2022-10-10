package com.dawson.domain.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章表(Article)表实体类
 *
 * @author makejava
 * @since 2022-10-05 14:16:30
 */
@SuppressWarnings("serial")
@Data//这个是设置getter、setter和toString
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
@TableName("ds_article")
public class Article{

    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;
    //分类名字。数据库中并没有对应的字段，这里设置完全是用来后面和VO一起封装
    @TableField(exist = false)
    private String categoryName;
    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    @TableField(fill = FieldFill.UPDATE)
    private Long createBy;
    @TableField(fill = FieldFill.UPDATE)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

    public Article(Long id, long viewCount) {
        this.id = id;
        this.viewCount = viewCount;
    }
}


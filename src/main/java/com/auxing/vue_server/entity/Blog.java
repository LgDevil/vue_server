package com.auxing.vue_server.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author auxing
 * @since 2019-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Blog extends Model<Blog> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("TITLE")
    private String title;

    @TableField("HTML")
    private String html;

    @TableField("STARTDATE")
    private String startdate;

    @TableField("AUTHOR")
    private String author;

    @TableField("BLOGINDEX")
    private String blogindex;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

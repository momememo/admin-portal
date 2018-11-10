package com.baiwang.admin.portal.bean.entity;

import com.baiwang.admin.portal.bean.base.BaseEntity;

/**
 * @Description: 接口分组bean
 * @author: liyunfei
 * @date: 2018/9/3 16:02
 */
public class Group extends BaseEntity {

    private Integer groupId;
    private String groupName;
    private String desc;

    public Group() {
    }

    public Group(Integer groupId, String groupName, String desc) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.desc = desc;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

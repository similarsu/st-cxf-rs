package cn.st.cxf.rs.entity;

import java.util.Date;

import cn.st.cxf.rs.serializer.DateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Student {
    private Long id;
    private String name;
    private int age;
    @JsonSerialize(using = DateSerializer.class)
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Student() {}

    public Student(Long id, String name, int age, Date createDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createDate = createDate;
    }

}

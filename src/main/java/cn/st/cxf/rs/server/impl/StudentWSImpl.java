package cn.st.cxf.rs.server.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.apache.cxf.jaxrs.ext.MessageContext;

import cn.st.cxf.rs.entity.Student;
import cn.st.cxf.rs.server.StudentWS;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentWSImpl implements StudentWS {
    @Context
    private MessageContext messageContext;

    private static Map<Long, Student> studentMap;

    static {
        studentMap = new HashMap<Long, Student>();
        studentMap.put(1l, new Student(1l, "张三1", 21, new Date()));
        studentMap.put(2l, new Student(2l, "222", 22, new Date()));
        studentMap.put(3l, new Student(3l, null, 23, new Date()));
    }

    @Override
    public String add(Student st) throws Exception {
        // TODO Auto-generated method stub
        return new ObjectMapper().writeValueAsString(st != null ? "插入成功！" : "插入失败");
    }

    @Override
    public Student find(Long id) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(getIp());
        return studentMap.get(id);
    }

    @Override
    public String delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        return new ObjectMapper().writeValueAsString(studentMap.get(id).getName());
    }

    @Override
    public String addGET(String st) throws Exception {
        // TODO Auto-generated method stub
        Student student = new ObjectMapper().readValue(st, Student.class);
        return new ObjectMapper().writeValueAsString(student != null ? "插入成功！" : "插入失败");
    }

    private String getIp() {
        HttpServletRequest request = messageContext.getHttpServletRequest();
        return request.getRemoteAddr();
    }

}

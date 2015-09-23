package cn.st.cxf.rs.server.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.http.HttpHeaders;

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
    public Response find(Long id) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(getIp());
        return Response.ok().entity(studentMap.get(id))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + ";charset=UTF-8")
                .build();
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

    @Override
    public String upload(String name, List<Attachment> attachments, MultipartBody body)
            throws Exception {

        for (Attachment a : attachments) {
            DataHandler handler = a.getDataHandler();
            ContentDisposition cd = a.getContentDisposition();
            System.out.println();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(handler.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        return new ObjectMapper().writeValueAsString("上传成功！");
    }

    private String getIp() {
        HttpServletRequest request = messageContext.getHttpServletRequest();
        return request.getRemoteAddr();
    }

}

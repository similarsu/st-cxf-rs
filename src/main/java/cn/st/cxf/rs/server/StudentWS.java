package cn.st.cxf.rs.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import cn.st.cxf.rs.entity.Student;

@Produces(MediaType.APPLICATION_JSON)
@Path("/student")
public interface StudentWS {
    @POST
    @Path("/add")
    @Descriptions({@Description(value = "添加学生", target = DocTarget.METHOD),
            @Description(value = "返回结果", target = DocTarget.RETURN)})
    @Consumes(MediaType.APPLICATION_JSON)
    String add(@Description(value = "学生", target = DocTarget.PARAM) Student st) throws Exception;

    @GET
    @Path("/add2")
    @Descriptions({@Description(value = "添加学生", target = DocTarget.METHOD),
            @Description(value = "返回结果", target = DocTarget.RETURN)})
    @Consumes(MediaType.APPLICATION_JSON)
    String addGET(@Description(value = "学生", target = DocTarget.PARAM) @QueryParam("stu") String st)
            throws Exception;

    @GET
    @Path("/find/{id}")
    @Descriptions({@Description(value = "根据id查找学生", target = DocTarget.METHOD),
            @Description(value = "返回学生", target = DocTarget.RETURN)})
    @Consumes(MediaType.APPLICATION_JSON)
    Student find(@Description(value = "学生id", target = DocTarget.PARAM) @PathParam("id") Long id)
            throws Exception;

    @GET
    @Path("/delete/{id}")
    @Descriptions({@Description(value = "根据id删除学生", target = DocTarget.METHOD),
            @Description(value = "返回姓名", target = DocTarget.RETURN)})
    @Consumes(MediaType.APPLICATION_JSON)
    String delete(@Description(value = "学生id", target = DocTarget.PARAM) @PathParam("id") Long id)
            throws Exception;

}

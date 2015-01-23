package cn.st.cxf.rs.provider;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * <p>
 * description:自定义objectMapper
 * </p>
 * 
 * @author coolearth
 * @since 2014年12月24日
 * @version v1.0
 */
public class JsonMapper extends ObjectMapper {

    public JsonMapper() {
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
                    throws IOException, JsonProcessingException {
                jgen.writeString("");
            }
        });
    }

}

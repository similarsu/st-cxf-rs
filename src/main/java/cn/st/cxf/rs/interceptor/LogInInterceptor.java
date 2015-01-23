package cn.st.cxf.rs.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

public class LogInInterceptor extends AbstractPhaseInterceptor<Message> {

    public LogInInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        // TODO Auto-generated method stub
        HttpServletRequest request =
                (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
        String ip = request.getRemoteAddr(); // 取客户端IP地址
        String uri = (String) message.get(Message.REQUEST_URL);
        String address = (String) message.get(Message.ENDPOINT_ADDRESS);
        String query = (String) message.get(Message.QUERY_STRING);
        message.getExchange().put("ip", ip);
    }

}

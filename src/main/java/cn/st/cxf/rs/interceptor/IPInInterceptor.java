package cn.st.cxf.rs.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

/**
 * <p>
 * description:获取客户端IP
 * </p>
 * 
 * @author coolearth
 * @since 2014年11月21日
 * @version v1.0
 */
public class IPInInterceptor extends AbstractPhaseInterceptor<Message> {

    public IPInInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        // TODO Auto-generated method stub
        HttpServletRequest request =
                (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
        // 通过一个IpAddressConfig对象，从XML文件中读取预先设置的允许和拒绝的IP地址，这些值也可以来自数据库
        String ipAddress = request.getRemoteAddr(); // 取客户端IP地址
        System.out.println("in:" + ipAddress);
        message.getExchange().put("ip", ipAddress);
    }

}

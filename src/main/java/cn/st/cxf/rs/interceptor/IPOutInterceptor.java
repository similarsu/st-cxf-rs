package cn.st.cxf.rs.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * <p>
 * description:获取客户端IP
 * </p>
 * 
 * @author coolearth
 * @since 2014年11月21日
 * @version v1.0
 */
public class IPOutInterceptor extends AbstractPhaseInterceptor<Message> {

    public IPOutInterceptor() {
        super(Phase.SEND);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        // TODO Auto-generated method stub
        System.out.println("out:" + message.getExchange().get("ip"));
    }

}

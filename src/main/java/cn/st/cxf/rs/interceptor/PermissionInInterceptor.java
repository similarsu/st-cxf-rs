package cn.st.cxf.rs.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

/**
 * <p>
 * description:权限拦截
 * </p>
 * 
 * @author coolearth
 * @since 2015年4月29日
 * @version v1.0
 */
public class PermissionInInterceptor extends AbstractPhaseInterceptor<Message> {

    public PermissionInInterceptor() {
        super(Phase.PRE_INVOKE);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        // TODO Auto-generated method stub
        HttpServletRequest request =
                (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
        String authorization = request.getHeader("authorization");
        if (authorization == null || authorization.equals("")) {
            throw new Fault(new IllegalArgumentException("没有authorization,拦截器实施拦截"));
        }
        String userAndPass = new String(Base64.decodeBase64(authorization.split(" ")[1]));
        if (userAndPass.split(":").length < 2) {
            throw new Fault(new IllegalArgumentException("没有authorization,拦截器实施拦截"));
        }
        String user = userAndPass.split(":")[0];
        String pass = userAndPass.split(":")[1];
        System.out.println(user + ":" + pass);
    }

}

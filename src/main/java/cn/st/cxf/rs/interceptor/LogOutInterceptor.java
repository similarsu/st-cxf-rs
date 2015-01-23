package cn.st.cxf.rs.interceptor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class LogOutInterceptor extends AbstractPhaseInterceptor<Message> {

    public LogOutInterceptor() {
        super(Phase.PRE_STREAM);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        // TODO Auto-generated method stub
        try {

            OutputStream os = message.getContent(OutputStream.class);

            CachedStream cs = new CachedStream();

            message.setContent(OutputStream.class, cs);

            message.getInterceptorChain().doIntercept(message);

            CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
            InputStream in = csnew.getInputStream();

            String xml = IOUtils.toString(in);

            // 这里对xml做处理，处理完后同理，写回流中
            IOUtils.copy(new ByteArrayInputStream(xml.getBytes()), os);

            cs.close();
            os.flush();

            message.setContent(OutputStream.class, os);

        } catch (Exception e) {}
    }

    private class CachedStream extends CachedOutputStream {

        public CachedStream() {

            super();

        }

        protected void doFlush() throws IOException {

            currentStream.flush();

        }

        protected void doClose() throws IOException {

        }

        protected void onWrite() throws IOException {

        }

    }

}

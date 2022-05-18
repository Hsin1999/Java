package TCPDownload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 19:51
 */
public class toByte {
    public static byte[] tobyte(InputStream in) throws IOException {
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        int len;
        byte[] bytes=new byte[1024];
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        return out.toByteArray();
    }
}

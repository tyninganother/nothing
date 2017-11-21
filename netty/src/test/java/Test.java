import com.tyning.nothing.netty.http.client.TimeClient;

/**
 * Created by haining on 2017/11/21.
 */
public class Test {
    @org.junit.Test
    public void test(){
        TimeClient client = new TimeClient();
        client.sendMessage();
    }
}

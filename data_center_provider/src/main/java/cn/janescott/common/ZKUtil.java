package cn.janescott.common;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by scott on 2017/9/5.
 */
public class ZKUtil {
    public static ZkClient getZKClient(){
        return new ZkClient(Constants.ZOOKEEPER_CONNECTIONS, 5000);
    }
}

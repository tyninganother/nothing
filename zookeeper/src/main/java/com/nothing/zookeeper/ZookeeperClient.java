//package com.nothing.zookeeper;
//
//import org.apache.curator.RetryPolicy;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//
///**
// * zookeeper client
// * <p>
// * curator-framework：对zookeeper的底层api的一些封装。
// * curator-client：提供一些客户端的操作，例如重试策略等。
// * curator-recipes：封装了一些高级特性，如：Cache事件监听、选举、分布式锁、分布式计数器、分布式Barrier等。
// * </p>
// *
// * @author haining
// */
//public class ZookeeperClient {
//    /**
//     * client
//     * <p>
//     * connectionString	服务器列表，格式host1:port1,host2:port2,…
//     * retryPolicy	重试策略,内建有四种重试策略,也可以自行实现RetryPolicy接口
//     * sessionTimeoutMs	会话超时时间，单位毫秒，默认60000ms
//     * connectionTimeoutMs	连接创建超时时间，单位毫秒，默认60000ms
//     * </p>
//     */
//    public CuratorFramework createCuratorFramework(int typeValue) {
//        //1.使用静态工程方法创建客户端
//        if (typeValue == 1) {
//            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//            CuratorFramework client =
//                    CuratorFrameworkFactory.newClient(
//                            connectionInfo,
//                            5000,
//                            3000,
//                            retryPolicy);
//            return client;
//        } else if (typeValue == 2) {
//            //2.使用Fluent风格的Api创建会话
//            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//            CuratorFramework client =
//                    CuratorFrameworkFactory.builder()
//                            .connectString(connectionInfo)
//                            .sessionTimeoutMs(5000)
//                            .connectionTimeoutMs(5000)
//                            .retryPolicy(retryPolicy)
//                            .build();
//            return client;
//        } else if (typeValue == 3) {
//            //3.创建包含隔离命名空间的会话
//            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//            CuratorFramework client =
//                    CuratorFrameworkFactory.builder()
//                            .connectString(connectionInfo)
//                            .sessionTimeoutMs(5000)
//                            .connectionTimeoutMs(5000)
//                            .retryPolicy(retryPolicy)
//                            .namespace("base")
//                            .build();
//            return client;
//        } else {
//
//        }
//        return null;
//    }
//
//
//    /**
//     * start client
//     */
//    public void start(){
//        CuratorFramework curatorClinet = createCuratorFramework(1);
//        curatorClinet.start();
//    }
//
//    public static void main(String[] args) {
//        ZookeeperClient zookeeperClient = new ZookeeperClient();
//        zookeeperClient.start();
//    }
//}

package com.ezreal.demo.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * Created by tao.mao on 2020/6/29.
 */
public class ZKDemo {

    public static void main(String[] args) throws Exception {

        ZooKeeper zk = new ZooKeeper("localhost:8121", 1000000, (event) -> {
            System.out.println("监听事件1:" + event.toString());
        });
        List<String> list =  zk.getChildren("/demo/leader/node1",  (event) -> {
            System.out.println("监听事件2：" + event.toString());
        });
        zk.create("/demo/leader/node1/7", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        /*byte[] bytes = zk.getData("/MAIL/mailStatusByQueueJob/config", false, null);
        System.out.println(new String(bytes));*/
        zk.setData("/demo/leader/node1", "变更后10".getBytes(), 17);
        for (String path : list) {
            System.out.println(path);

        }

        // 创建zk节点不支持递归创建，只能一层一层创建
        //zk.create("/demo", "key1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //zk.create("/demo/leader", "key2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // zk.create("/demo/leader/node1", "key3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        Thread.currentThread().sleep(5000);

    }
}

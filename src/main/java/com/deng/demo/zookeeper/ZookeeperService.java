//package com.deng.demo.zookeeper;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.recipes.cache.PathChildrenCache;
//import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.ZooDefs;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.CountDownLatch;
//
//
//public class ZookeeperService implements InitializingBean {
//
//    @Autowired
//    private CuratorFramework curatorFramework;
//    private static final Logger log = LoggerFactory.getLogger(ZookeeperService.class);
//    private CountDownLatch countDownLatch = new CountDownLatch(1);
//    private final static String ROOT_PATH_LOCK = "rootlock";
//
//
//    public String lock(String path) {
//
//
//        String keyPath ="/" + ROOT_PATH_LOCK + "/" + path;
//        while (true) {
//            try {
//                curatorFramework
//                        .create()
//                        .creatingParentsIfNeeded()
//                        .withMode(CreateMode.EPHEMERAL)
//                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
//                        .forPath(keyPath);
//                log.info("success to acquire lock for path:{}", keyPath);
//                System.out.println("已经加锁了, name=" + keyPath);
//                Thread.sleep(50000);
//                break;
//            } catch (Exception e) {
//                log.info("failed to acquire lock for path:{}", keyPath);
//                log.info("while try again .......");
//                try {
//                    if (countDownLatch.getCount() <= 0) {
//                        countDownLatch = new CountDownLatch(1);
//                    }
//                    countDownLatch.await();
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//
//        }
//        return "success";
//
//    }
//
//    /**
//     * 释放分布式锁
//     */
//    public boolean releaseDistributedLock(String path) {
//        try {
//            String keyPath ="/" + ROOT_PATH_LOCK + "/" + path;
//            if (curatorFramework.checkExists().forPath(keyPath) != null) {
//                curatorFramework.delete().forPath(keyPath);
//            }
//        } catch (Exception e) {
//            log.error("failed to release lock");
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 创建 watcher 事件
//     */
//    private void addWatcher(String path) throws Exception {
//        String keyPath;
//        if (path.equals(ROOT_PATH_LOCK)) {
//            keyPath = "/" + path;
//        } else {
//            keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
//        }
//        final PathChildrenCache cache = new PathChildrenCache(curatorFramework, keyPath, false);
//        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
//        cache.getListenable().addListener((client, event) -> {
//            if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)) {
//                String oldPath = event.getData().getPath();
//                log.info("上一个节点 " + oldPath + " 已经被断开");
//                if (oldPath.contains(path)) {                    //释放计数器，让当前的请求获取锁
//                    countDownLatch.countDown();
//                }
//            }
//        });
//    }     //创建父节点，并创建永久节点
//
//    @Override
//    public void afterPropertiesSet() {
//        curatorFramework = curatorFramework.usingNamespace("lock-namespace");
//        String path = "/" + ROOT_PATH_LOCK;
//        try {
//            if (curatorFramework.checkExists().forPath(path) == null) {
//                curatorFramework.create()
//                        .creatingParentsIfNeeded()
//                        .withMode(CreateMode.PERSISTENT)
//                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
//                        .forPath(path);
//            }
//            addWatcher(ROOT_PATH_LOCK);
//            log.info("root path 的 watcher 事件创建成功");
//        } catch (Exception e) {
//            log.error("connect zookeeper fail，please check the log >> {}", e.getMessage(), e);
//        }
//    }
//
//
//}
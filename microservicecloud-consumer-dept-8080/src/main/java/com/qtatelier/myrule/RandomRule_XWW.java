package com.qtatelier.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * @author JazzXia
 * @create 2019-11-03-10:12
 * @email jazzxiaw@qq.com
 * @since 2019
 */
public class RandomRule_XWW extends AbstractLoadBalancerRule {

    //分析：我们5次，但是微服务只有8001,8002,8003三台，index要置为0

    private int total = 0;    //总共被调用的次数，目前要求每台被调用5次，当total==5之后才能往下走,随后置为0
    private int currentIndex = 0;//当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key) {

        //负载均衡不能为空
        if (lb == null) {
            return null;
        }

        //服务初始化
        Server server = null;
        //判断服务是否为空
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }


//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);
            //算法中如果次数小于五，就继续增加，满五次之后才进入else并将次数置为0
            if(total < 5)
            {
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if(currentIndex >= upList.size())
                {
                    currentIndex = 0;
                }

            }


            //线程

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}

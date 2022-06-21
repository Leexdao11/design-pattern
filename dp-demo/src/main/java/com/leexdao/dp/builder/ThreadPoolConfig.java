package com.leexdao.dp.builder;

/**
 * @description: 建造者模式
 * 适用场景：
 * 1. 构造函数的参数过多,创建是传入多个参数 容易顺序混淆 同时对于阅读理解不友好
 * 2. 适用于对于多个参数有逻辑校验
 * 3. 适用于创建不可变的对象，同时可以避免对象的无效状态，一次性创建整个对象，创建记可用
 * 下面以创建一个线程池为demo
 * @author: leexdao
 * @create: 2022-05-30
 **/
public class ThreadPoolConfig {
    /**
     * 线程名
     */
    private String name;
    private int corePoolSize;
    private int maxPoolSize;
    private int keepAliveTime;
    private Builder builder;

    private ThreadPoolConfig(Builder builder) {
        this.corePoolSize = builder.corePoolSize;
        this.keepAliveTime = builder.keepAliveTime;
        this.maxPoolSize = builder.maxPoolSize;
        this.name = builder.name;
    }

    public static class Builder {
        /**
         * 核心线程数
         */
        private static int DEFAULT_CORE_POOL_SIZE = 8;
        /**
         * 最大线程数
         */
        private static int MAX_CORE_POOL_SIZE = 10;
        /**
         * 线程的空闲时间(秒)
         */
        private static int KEEP_ALIVE_TIME = 30;
        private String name;
        private int corePoolSize = DEFAULT_CORE_POOL_SIZE;
        private int maxPoolSize = MAX_CORE_POOL_SIZE;
        private int keepAliveTime = KEEP_ALIVE_TIME;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
            return this;
        }

        public Builder setMaxPoolSize(int maxPoolSize) {
            if(maxPoolSize<corePoolSize){
                throw new RuntimeException("this is invalid: maxPoolSize must > corePoolSize!!!");
            }
            this.maxPoolSize = maxPoolSize;
            return this;
        }

        public Builder setKeepAliveTime(int keepAliveTime) {
            this.keepAliveTime = keepAliveTime;
            return this;
        }

        public ThreadPoolConfig build() {
            return new ThreadPoolConfig(this);
        }
    }

    public static ThreadPoolConfig getConfig() {
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig.Builder()
                .setCorePoolSize(10).setMaxPoolSize(8).setName("thread-pool").setKeepAliveTime(30).build();
        return threadPoolConfig;
    }

    /**此处会抛出异常*/
    public static void main(String[] args) {
        ThreadPoolConfig.getConfig();
    }
}

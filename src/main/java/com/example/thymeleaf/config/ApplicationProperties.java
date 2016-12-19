package com.example.thymeleaf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

/**
 * Created by bawer on 17.12.2016.
 * Fetch exampleApp properties from application.yml
 */
@ConfigurationProperties(prefix = "exampleApp", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Async async = new Async();

    private final Mail mail = new Mail();

    private final Security security = new Security();

    public Async getAsync() {
        return async;
    }

    public Mail getMail() {
        return mail;
    }

    public Security getSecurity() {
        return security;
    }

    public static class Async {

        private int corePoolSize = 2;

        private int maxPoolSize = 50;

        private int queueCapacity = 10000;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }

    public static class Mail {

        private String from = "denememailsrd@gmail.com";

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }

    public static class Security {

        private final RememberMe rememberMe = new RememberMe();

        public RememberMe getRememberMe() {
            return rememberMe;
        }

        public static class RememberMe {

            @NotNull
            private String key;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }

}

package cn.timelost.hr.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("upyun")
@Data
public class UpYunConfig {

    private String bucketName;

    private String username;

    private String password;

    private String imageHost;
}

/**
 * @author vnightray
 * date 2022-06-01
 * author vessa
 * project_name springbootvue
 */
package com.vnightray.admin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class VnightrayAdminInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VnightrayAdminApplication.class);
    }
}

package com.angelectro.zt.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Zahit Talipov on 02.10.2015.
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{Config.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{Config.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

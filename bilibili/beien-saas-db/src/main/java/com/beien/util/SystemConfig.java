package com.beien.util;

import com.beien.enums.ISysconfigKey;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author itbeien
 * @version 1.0
 * @date 2023年5月21日
 */
public class SystemConfig {

    private static SystemConfig instance;

    private PropertySources configGroupSources;

    private SystemConfig() {
        //私有构造函数
    }

    public static synchronized SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }



    public static String getProperty(ISysconfigKey key) {
        if (instance.configGroupSources != null) {
            Iterator<PropertySource<?>> iterator = instance.configGroupSources.iterator();
            while (iterator.hasNext()) {
                PropertySource<?> propertySource = iterator.next();
                if (propertySource.containsProperty(key.getKey())) {
                    return String.valueOf(propertySource.getProperty(key.getKey()));
                }
            }
        }
        return null;
    }


    public static String getProperty(ISysconfigKey key, Map<String, String> params) {
        if (instance.configGroupSources != null) {
            Iterator<PropertySource<?>> iterator = instance.configGroupSources.iterator();
            while (iterator.hasNext()) {
                PropertySource<?> propertySource = iterator.next();
                if (propertySource.containsProperty(key.getKey())) {
                    return replaceArgs(String.valueOf(propertySource.getProperty(key.getKey())), params);
                }
            }
        }
        return null;
    }

    /**
     * 替换模板变量
     *
     * @param template
     * @param data
     * @return
     */
    private static String replaceArgs(String template, Map<String, String> data) {
        StringBuffer sb = new StringBuffer();
        try {
            Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");
            Matcher matcher = pattern.matcher(template);
            while (matcher.find()) {
                String name = matcher.group(1);// 键名
                String value = (String) data.get(name);// 键值
                if (value == null) {
                    value = "";
                } else {
                    value = value.replaceAll("\\$", "\\\\\\$");
                }
                matcher.appendReplacement(sb, value);
            }
            matcher.appendTail(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public PropertySources getConfigGroupSources() {
        return configGroupSources;
    }

    public void setConfigGroupSources(PropertySources configGroupSources) {
        this.configGroupSources = configGroupSources;
    }

}

package com.example.novaride.utilities;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

public class YamlPropertySourceFactory extends DefaultPropertySourceFactory {
	@Override
	public org.springframework.core.env.PropertySource<?> createPropertySource(String name, EncodedResource resource)
			throws IOException {
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		factory.setResources(resource.getResource());
		Properties properties = factory.getObject();
		return new PropertiesPropertySource(resource.getResource().getFilename(), properties);
	}
}

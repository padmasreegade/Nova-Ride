package com.example.novaride.utilities;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.example.novaride.entity.Checkpoint;

import jakarta.annotation.PostConstruct;

@Component
@EnableConfigurationProperties
@Configuration
@ConfigurationProperties
@PropertySource(factory = YamlPropertySourceFactory.class, value = { "checkpoints.yml" })
public class CheckpointConfig {
	private List<Checkpoint> checkpoints;

	public List<Checkpoint> getCheckpoints() {
		return this.checkpoints;
	}

	public void setCheckpoints(List<Checkpoint> checkpoints) {
		this.checkpoints = checkpoints;
	}
}

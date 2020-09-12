package com.checkapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

// three components
//Rule -> Avail
// Ping - to check if the server is live
//serverlist -  dynamic, static


@Configuration
public class RibbonConfig {
		
	@Bean
	public IRule customRule() {
//		return new WeightedResponseTimeRule();
		return new AvailabilityFilteringRule();
	}

}

//package com.deng.demo.casConfig;
//
//import org.jasig.cas.client.authentication.AuthenticationFilter;
//import org.jasig.cas.client.session.SingleSignOutFilter;
//import org.jasig.cas.client.session.SingleSignOutHandler;
//import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CasclientConfig1 {
//
//    @Bean
//	public FilterRegistrationBean logoutFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
//		registration.setFilter(singleSignOutFilter);
//		registration.addUrlPatterns("/*");
//		registration.addInitParameter("casServerUrlPrefix", "http://localhost:8088/cas");
//		registration.setName("logoutFilter");
//
//		return registration;
//	}
//	/**
//	 * 配置auth过滤器
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean casAuthFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new AuthenticationFilter());
//        registration.addInitParameter("casServerUrlPrefix","http://localhost:8088/cas");
//        registration.addInitParameter("serverName","http://127.0.0.1:8090");
//        registration.addUrlPatterns("/*");
//		registration.setName("authFilter");
//		return registration;
//	}/*** 配置ticket过滤器* @return*/
//	@Bean
//	public FilterRegistrationBean casTicketFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new Cas20ProxyReceivingTicketValidationFilter());
//		registration.addUrlPatterns("/*");
//		registration.addInitParameter("encoding", "UTF-8");
//        registration.addInitParameter("casServerUrlPrefix","http://localhost:8088/cas");
//        registration.addInitParameter("serverName","http://127.0.0.1:8090");
//        registration.setName("ticketFilter");
//		return registration;
//	}
//
//   // @Bean
//   // public FilterRegistrationBean requestWrapperFilterRegistration() {
//   //     FilterRegistrationBean registration = new FilterRegistrationBean();
//   //     registration.setFilter(new HttpServletRequestWrapperFilter());
//   //     registration.addUrlPatterns("/*");
//   //     registration.setName("requestWrapperFilter");
//   //     return registration;
//   // }
////
//
//}

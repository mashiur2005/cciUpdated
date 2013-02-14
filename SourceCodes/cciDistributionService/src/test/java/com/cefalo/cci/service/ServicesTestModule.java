package com.cefalo.cci.service;// TestModule.java, created by Fabio Strozzi on Mar 27, 2011

import com.google.inject.AbstractModule;

/**
 * A trivial Guice configuration.
 * 
 * @author Fabio Strozzi
 */
public class ServicesTestModule extends AbstractModule {

    /*
     * (non-Javadoc)
     * 
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {
      bind(HelloService.class).to(HelloServiceImpl.class);
    }

}

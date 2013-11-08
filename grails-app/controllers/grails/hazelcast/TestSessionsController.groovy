package grails.hazelcast

import com.hazelcast.client.*
import com.hazelcast.config.*
import com.hazelcast.core.*
import groovy.util.logging.*

@Log
class TestSessionsController {

    def index() { 
        session.setAttribute("testAttr","testVal");
    	Config cfg = new Config();
        HazelcastInstance hz = Hazelcast.newHazelcastInstance(cfg);
	IMap map = hz.getMap("my-sessions");
        log.info "SIZE========"+map.size();
    }
}

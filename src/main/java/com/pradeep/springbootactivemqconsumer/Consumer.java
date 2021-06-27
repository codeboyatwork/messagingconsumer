package com.pradeep.springbootactivemqconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@Autowired
    private JdbcTemplate jdbcTemplate;
		@Autowired
		public Consumer() {
		
		}
		
	    @JmsListener(destination = "messaging.preprocessor")
	    public void listener(String message) {
	        //write logic to save in db
	    	try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String sql = "INSERT INTO messaging.base_table (data,status) VALUES (?,?)";
	        int result = jdbcTemplate.update(sql, message,"UNPROCESSED");
	        if (result > 0) {
	            System.out.println("A new row has been inserted.");
	        }
	    }
}

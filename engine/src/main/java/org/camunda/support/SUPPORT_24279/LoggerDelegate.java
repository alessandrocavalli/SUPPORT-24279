package org.camunda.support.SUPPORT_24279;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
@Component("logger")
public class LoggerDelegate implements JavaDelegate {
 
  
  public void execute(DelegateExecution execution) throws Exception {
    
    Integer.valueOf("aaaa");
  }

}

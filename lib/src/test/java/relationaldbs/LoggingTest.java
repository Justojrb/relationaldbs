package relationaldbs;



import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

/**
 * 
 *@author Justo
 *3 mar 2026
 */
public class LoggingTest {
	
	
private final static Logger logger = (Logger) LoggerFactory.getLogger(LoggingTest.class); 
	public static void main(String[] args) {
//      Logger.setLeveL(Level.TRACE);
//	    Logger.setLeveL(Level.DEBUG);
//	    Logger.setLeveL(Level.INFO);
//	    Logger.setLeveL(Level.WARN);
//	    Logger.setLeveL(Level.ERROR);
		logger.setLevel(Level.INFO);
		ch.qos.logback.classic.filter.ThresholdFilter filter = new ch.qos.logback.classic.filter.ThresholdFilter();
		division(20, 0);
	}
	
	private static void division(int i, int j) {
		//this level of information has less importance 
		logger.trace("trace info-very detailed info: You have entered the method division");
		//We use this level of information for test 
		logger.debug("test info: division method test");
		//We use this level of log for normal and general information 
		logger.info("main general info to show our app is running normally");
		//We use this level of log for potential problems 
		logger.warn("unexpected problem but not vital");
		//This is for errors 
		logger.error("serious problem that should be resolved");
		if(j== 0) {
			logger.info("the user has pass a zero as divisor");
		}
		try {
			int result= i/j;
			logger.info("the result is :" + result);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
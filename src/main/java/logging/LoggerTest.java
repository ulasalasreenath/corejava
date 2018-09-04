package logging;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {


    static Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {

        int i = 5;

        logger.info("value of i is {}", i);

        System.out.println("finished");

        try {

            throw new RuntimeException("test");

        } catch(Exception e) {

            logger.error("Exception occurred {}", ExceptionUtils.getStackTrace(e));

        }

        try {
            testException();
        }catch(Exception e) {
            logger.error("Exception occurred {}" , ExceptionUtils.getStackTrace(e));
            String msg = "Exception occurred {}";
            logger.error(msg, ExceptionUtils.getStackTrace(e), e);

//            String message = "Exception occurred while File conversion for task id : " + "task Id" + " and document Id : " + "document id" + " .Exception : {}";
//            logger.error(message, ExceptionUtils.getStackTrace(e));
        }



    }

    static void testException() {

        for(int i = 0 ; i < 100; i++) {
            if (i == 5) {
                throw new RuntimeException("failed to iterate");
            }
        }
    }



}

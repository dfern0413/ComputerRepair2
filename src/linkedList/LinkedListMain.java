package linkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedListMain {
    private final static Logger LOGGER = LogManager.getLogger(LinkedListMain.class);
        public static void main(String[] args) {
            LinkedList<Integer>linkedList = new LinkedList<>();
            LOGGER.info("First test");
            linkedList.add(1);
            linkedList.add(2);
            linkedList.show();
            LOGGER.info("Second test");
            linkedList.addAt(0, 25);
            linkedList.add(125);
            linkedList.show();
            LOGGER.info("Third test");
            linkedList.removeAt(0);
            linkedList.show();
            linkedList.removeAt(2);
            linkedList.show();
            linkedList.clear();
            linkedList.show();


        }


}

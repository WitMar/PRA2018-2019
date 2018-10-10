package second.shortcuts;

import org.apache.log4j.Logger;

import java.util.List;

public class ClassThatHaveItAll implements InterfaceOne {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ClassThatHaveItAll.class);

    List<Long> list;

    String name;
    Integer number;

    public void printMe(String info) {
        logger.info(info);
    }

    public void usageOfPrint() {
        printMe("Hi");
    }

    public ClassThatHaveItAll(List<Long> list, String name, Integer number) {
        this.list = list;
        this.name = name;
        this.number = number;
    }

    public static Logger getLogger() {
        return logger;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

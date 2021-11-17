package ioc.initdestroy;

import org.springframework.beans.factory.DisposableBean;

public class MessageTwo implements DisposableBean {
    private String value="Message Two";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     *
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     */
    public void destroy() throws Exception {
         setValue("Empty Value!!!!!!");
    }
}

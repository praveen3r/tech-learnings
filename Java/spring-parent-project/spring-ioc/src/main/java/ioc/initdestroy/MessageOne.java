package ioc.initdestroy;

import org.springframework.beans.factory.InitializingBean;

public class MessageOne implements InitializingBean {

    private String value = "Message One";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    public void afterPropertiesSet() throws Exception {

        setValue(getValue() + "Added some more details using Object initiation!!!");

    }
}

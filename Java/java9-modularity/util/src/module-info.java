import com.demo.hello.HelloInterface;
import com.demo.hello.HelloModules;

module util {
    exports com.util;
    exports com.demo.hello;
    provides com.demo.hello.HelloInterface with com.demo.hello.HelloModules;

}
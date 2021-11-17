package pureannotations.example1.service;

import pureannotations.example1.drivers.DataBaseDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    @Qualifier("oracleDriver")
    private DataBaseDriver dataBaseDriver;

    public String getDriverInfo(){
        return dataBaseDriver.getInfo();
    }
}

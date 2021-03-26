import com.xxb.dao.BaseDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Properties;

public class test {


    public static void main(String[] args) throws ParseException, SQLException {
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, user, password);
        Driver driver = DriverManager.getDriver(url);
        System.out.println(driver);
        System.out.println(connection);
    }


}


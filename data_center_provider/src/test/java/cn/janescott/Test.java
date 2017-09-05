package cn.janescott;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scott on 2017/9/5.
 */
public class Test {

    public static void main(String[] args) {
        try {
            Class a = Class.forName("cn.janescott.Config");
            Object o = a.newInstance();
            Map<String, String> params = new HashMap<>();
            params.put("name", "scott");
            params.put("password", "root123");
            params.put("id", "120305109");
            if (o instanceof Config) {
                Config config = (Config)o;
                for (Map.Entry<String, String> param : params.entrySet()) {
                    Field field = config.getClass().getDeclaredField(param.getKey());
                    field.setAccessible(true);
                    field.set(config, param.getValue());
                }
                System.out.println(config);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
class Config implements java.io.Serializable{
    private String name;

    private String password;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Config{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}

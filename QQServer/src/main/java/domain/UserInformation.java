package domain;

import java.sql.Timestamp;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/30 19:27
 * 数据库UserInformation表
 */
public class UserInformation {
    private Integer id;
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Timestamp createtime;
    public UserInformation(){};

    public UserInformation(Integer id, String username, String password, Timestamp createtime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public String getusername() {
        return username;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}

package common;

import java.io.Serializable;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 22:21
 * 用户信息
 */
public class User implements Serializable {
    private static final long serialVersionUID=1L;
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}

package im.youyu.mvpdemo.Model;

import im.youyu.mvpdemo.Bean.User;

/**
 * Created by fujh on 16/6/12.
 */
public interface HttpListener {

    public void onSuccess(User user);

    public void onFailure();
}

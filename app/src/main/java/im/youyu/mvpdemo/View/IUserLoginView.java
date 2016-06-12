package im.youyu.mvpdemo.View;

import im.youyu.mvpdemo.Bean.User;

/**
 * Created by fujh on 16/6/12.
 * view层  需要实现的ui操作的接口
 */
public interface IUserLoginView {

    String getUsername();

    String getPassword();

    void clearUsername();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void showSuccess(User user);

    void showFailed();

}

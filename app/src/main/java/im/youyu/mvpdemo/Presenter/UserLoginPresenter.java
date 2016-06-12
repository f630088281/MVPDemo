package im.youyu.mvpdemo.Presenter;

import android.os.Handler;

import im.youyu.mvpdemo.Bean.User;
import im.youyu.mvpdemo.Model.HttpListener;
import im.youyu.mvpdemo.Model.HttpModel;
import im.youyu.mvpdemo.Model.HttpModelImp;
import im.youyu.mvpdemo.View.IUserLoginView;

/**
 * Created by fujh on 16/6/12.
 * presenter层  数据交互层
 */
public class UserLoginPresenter {
    private HttpModel model;
    private IUserLoginView view;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView view){
        this.view = view;
        this.model = new HttpModelImp();
    }

    public void login(){
        view.showLoading();
        model.login(view.getUsername(), view.getPassword(), new HttpListener() {
            @Override
            public void onSuccess(final User user) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.hideLoading();
                        view.showSuccess(user);
                    }
                });
            }

            @Override
            public void onFailure() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.hideLoading();
                        view.showFailed();
                    }
                });
            }
        });
    }

    public void clear(){
        view.clearUsername();
        view.clearPassword();
    }
}

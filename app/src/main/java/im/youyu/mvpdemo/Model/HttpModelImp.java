package im.youyu.mvpdemo.Model;

import im.youyu.mvpdemo.Bean.User;

/**
 * Created by fujh on 16/6/12.
 * model层  数据交互层
 */
public class HttpModelImp implements HttpModel{

    @Override
    public void login(final String username, final String password, final HttpListener listener) {

        new Thread(){

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                if (username.equals("fujh")&&password.equals("123")){

                    User user = new User(username, password);
                    listener.onSuccess(user);
                }else {
                    listener.onFailure();
                }
            }

        }.start();
    }
}

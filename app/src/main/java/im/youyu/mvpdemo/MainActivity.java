package im.youyu.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import im.youyu.mvpdemo.Bean.User;
import im.youyu.mvpdemo.Presenter.UserLoginPresenter;
import im.youyu.mvpdemo.View.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView{

    private EditText edit_username, edit_password;
    private Button btn_login, btn_clear;
    private ProgressBar progressBar;

    private UserLoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        presenter = new UserLoginPresenter(this);
    }

    private void initViews(){
        edit_username = (EditText)findViewById(R.id.edit_username);
        edit_password = (EditText)findViewById(R.id.edit_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clear();
            }
        });

    }

    @Override
    public String getUsername() {
        return edit_username.getText().toString();
    }

    @Override
    public String getPassword() {
        return edit_password.getText().toString();
    }

    @Override
    public void clearUsername() {
        edit_username.setText("");
    }

    @Override
    public void clearPassword() {
        edit_password.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showSuccess(User user) {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailed() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }
}

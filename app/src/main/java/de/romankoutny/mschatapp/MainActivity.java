package de.romankoutny.mschatapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.romankoutny.mschatapp.rest.RestCaller;

public class MainActivity extends AppCompatActivity
{
    private ChatAdapter adapter;
    private int msgCounter = 0;

    @BindView(R.id.recyclerView)    RecyclerView chatList;
    @BindView(R.id.editText)    EditText messageText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new ChatAdapter(MainActivity.this);

        chatList.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        chatList.setLayoutManager(mLayoutManager);

        chatList.setAdapter(adapter);

        getWindow().setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }


    @OnClick(R.id.button)
    void messageSend()
    {
        String msg = messageText.getText().toString();

        adapter.add(msgCounter++, msg);

        messageText.setText("");
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }


        String question = "Die App beendet sich";
        String input = "{\"question\": \"" + question + "\"}";

        new RestCaller().call(input);
    }
}

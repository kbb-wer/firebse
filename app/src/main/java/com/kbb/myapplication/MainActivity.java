package com.kbb.myapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
private EditText edname ,email;
private DatabaseReference mDataBase;
private String YSERKEY="yser";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init()
    {
        edname=findViewById(R.id.name);
        email=findViewById(R.id.email);
        mDataBase= FirebaseDatabase.getInstance().getReference(YSERKEY);
    }
public void save(View view)
{
String id=mDataBase.getKey();
String name=edname.getText().toString();
String emaill=email.getText().toString();
yser nevyser=new yser(id,name,emaill);
if (!TextUtils.isEmpty(name)&&  !TextUtils.isEmpty(emaill)   ){
    mDataBase.push().setValue(nevyser);
    Toast.makeText(this, "Поля СОХРАНИЛОС В Базе даних", Toast.LENGTH_SHORT).show();

}
else {
    Toast.makeText(this, "ПУСТОЙ ПОЛЯ", Toast.LENGTH_SHORT).show();
}

}
    public void email(View view)
    {

    }

}

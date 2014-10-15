package com.plam.simcard;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button button_getSIMInfo;
    private TextView number;
    private TextView privoid;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_getSIMInfo = (Button) this.findViewById(R.id.getSIMInfo);
        number = (TextView) this.findViewById(R.id.textView1);
        privoid = (TextView) this.findViewById(R.id.textView2);
        button_getSIMInfo.setOnClickListener(new ButtonListener());
    }
 
    class ButtonListener implements OnClickListener {
 
        @Override
        public void onClick(View v) {
            if (v == button_getSIMInfo) {
                SIMCardInfo siminfo = new SIMCardInfo(MainActivity.this);
                number.setText(siminfo.getNativePhoneNumber()==null?"无法读取":siminfo.getNativePhoneNumber());
                privoid.setText(siminfo.getProvidersName()==null?"无法移动网络":siminfo.getProvidersName());
            }
        }
 
    }
}

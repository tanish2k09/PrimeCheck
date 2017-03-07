package com.trial.primecheck;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    
        
        Button ok=(Button)findViewById(R.id.ok);
        
        ok.setOnClickListener(new View.OnClickListener() {

	        EditText num=(EditText)findViewById(R.id.num);
			@Override
			public void onClick(View arg0) {
				if((num.getText().length())==0)
				{return;}
		        TextView result=(TextView)findViewById(R.id.result);
		        
		        result.setText("");
		        
		        TextView factordisplay=(TextView)findViewById(R.id.factordisplay);

		        factordisplay.setText("");
		        
		        double number = Double.parseDouble(num.getText().toString());
		        boolean remainder=true;
		        if(number<2)
		        {
		        	result.setText("Nope");
		        	return;
		        }
		        else if(number>2)
		        {
		        	//calculate number of digits for sq. root
		        	double digits=num.getText().length();
		        	if((digits%2)==1)
		        	{
		        		digits++;
		        	}
		        	digits/=2;
		        	/////////////////////////////////////////
		        	double verify=Math.pow(10,digits);
		        	for(int cnt=2;(cnt<verify)&&(cnt<number);cnt++)
		        	{
		        		if((number%cnt)==0)
		        		{	
		        			remainder=false;
		        			break;
		        		}
		        		
		        	}	
		        }
		        if(remainder==true)
	        	{
	        		result.setText("Yes!");
	        	}
		        else if(remainder==false)
		        {
		        	result.setText("Nope");
		        }
		        
			}
		});
        
        Button factorize=(Button)findViewById(R.id.factorize);
        
        factorize.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText num=(EditText)findViewById(R.id.num);
				if((num.getText().length())==0)
				{return;}
				TextView factordisplay=(TextView)findViewById(R.id.factordisplay);
		        factordisplay.setMovementMethod(new ScrollingMovementMethod());
		        double number = Double.parseDouble(num.getText().toString());
		        if(number<1)
		        {
		        	return;
		        }
		        double duplicate=number;
		        factordisplay.setText("1.0");
		        for(double cnt=2;duplicate!=1;)
		        {		        	
		        	if((duplicate%cnt)==0)
		        	{
		        		factordisplay.append("x "+cnt);
		        		duplicate/=cnt;
		        	}
		        	else
		        	{
		        		cnt++;
		        	}
		        }
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

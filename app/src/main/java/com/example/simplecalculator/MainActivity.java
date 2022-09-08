package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;
import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    private Context context = null;

    /**
     * onCreate is where you initialize your activity. This method is called upon the activity's
     * startup. You override it to customize what will happen.
      */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This loads the XML layout that we created.
        // res/layout/activity_main.xml is pulled.
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        /**
         * Set up button behavior.
         * Each time an operator button is pressed, it should pull the two operands from their fields,
         * perform the calculation, and place the result in its corresponding TextView.
         */

        // Addition button.

        // Find its corresponding UI widget in the XML file.
        // Its name will be whatever ID we set for it in the XML attribute such as: android:id="@+id/button_add"
        Button button_add = findViewById(R.id.button_add);
        if (null == button_add)
        {
            // Error.
            return;
        }

        // Set the behavior for the button click.
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Call add function when the button is clicked.
                // This will handle calculation, and updating the UI.
                add();
            }
        });

        // Do the same for the rest of the buttons...

        // Subtraction button.
        Button button_subtract = findViewById(R.id.button_subtract);
        if (null == button_subtract)
        {
            // Error.
            return;
        }

        // Set the behavior for the button click.
        button_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Call this function when the button is clicked.
                // This will handle calculation, and updating the UI.
                subtract();
            }
        });

        // Multiply button.
        Button button_multiply = findViewById(R.id.button_multiply);
        if (null == button_multiply)
        {
            // Error.
            return;
        }

        // Set the behavior for the button click.
        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Call this function when the button is clicked.
                // This will handle calculation, and updating the UI.
                multiply();
            }
        });

        // Multiply button.
        Button button_divide = findViewById(R.id.button_divide);
        if (null == button_divide)
        {
            // Error.
            return;
        }

        // Set the behavior for the button click.
        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Call this function when the button is clicked.
                // This will handle calculation, and updating the UI.
                divide();
            }
        });

    }

    // Retrieve the first operand from its EditText field.
    private Integer get_num_a()
    {
        Integer answer = null;
        int num_a = -1;

        EditText edittext_num_a = findViewById(R.id.editText_number_a);
        if (null == edittext_num_a)
        {
            // Error.
            return answer;
        }

        // Grab the contents of the EditText as a string.
        String num_a_str = edittext_num_a.getText().toString();

        if (null == num_a_str)
        {
            // Error.
            return answer;
        }

        // Convert the string to a double.
        try
        {
            num_a = Integer.parseInt(num_a_str);
        }
        catch (NumberFormatException nfe)
        {
            // Error. Was not a valid number.
            return answer;
        }

        answer = new Integer(num_a);

        return answer;
    }

    // Retrieve the second operand from its EditText field.
    private Integer get_num_b()
    {
        Integer answer = null;
        int num_b = -1;

        EditText edittext_num_b = findViewById(R.id.editText_number_b);
        if (null == edittext_num_b)
        {
            // Error.
            return answer;
        }

        // Grab the contents of the EditText as a string.
        String num_b_str = edittext_num_b.getText().toString();

        if (null == num_b_str)
        {
            // Error.
            return answer;
        }

        // Convert the string to a double.
        try
        {
            num_b = Integer.parseInt(num_b_str);
        }
        catch (NumberFormatException nfe)
        {
            // Error. Was not a valid number.
            return -1;
        }

        answer = new Integer(num_b);

        return answer;
    }

    // Set the TextView to an integer, our answer.
    private void set_result(int answer)
    {
        // Find the result TextView.
        TextView result = findViewById(R.id.text_result);
        if (null == result)
        {
            // Error.
            return;
        }

        // Convert integer to string, and update the TextView.
        result.setText(String.valueOf(answer));

    }

    // Updates the UI to reflect that an error in calculation occurred.
    private void set_error()
    {
        // Find the result TextView.
        TextView result = findViewById(R.id.text_result);
        if (null == result)
        {
            // Error.
            return;
        }

        // Convert integer to string, and update the TextView.
        result.setText("Error");

    }

    // Wraps all action and behavior for addition button.
    private void add()
    {
        // Grab the current contents of the first operand's field.
        final Integer num_a = get_num_a();
        if (null == num_a)
        {
            set_error();
            return;
        }

        // Grab the second operand from its field.
        final Integer num_b = get_num_b();
        if (null == num_b)
        {
            set_error();
            return;
        }

        int result = -1;

        try
        {
            result = Math.addExact(num_a.intValue(), num_b.intValue());
        }
        catch (Exception e)
        {
            set_error();
            return;
        }

        // Set the result
        set_result(result);
    }

    // Wraps all action and behavior for subtract button.
    private void subtract()
    {
        // Grab the current contents of the first operand's field.
        final Integer num_a = get_num_a();
        if (null == num_a)
        {
            set_error();
            return;
        }

        // Grab the second operand from its field.
        final Integer num_b = get_num_b();
        if (null == num_b)
        {
            set_error();
            return;
        }

        int result = -1;

        try
        {
            result = Math.subtractExact(num_a.intValue(), num_b.intValue());
        }
        catch (Exception e)
        {
            set_error();
            return;
        }

        // Set the result
        set_result(result);
    }

    // Wraps all action and behavior for multiply button.
    private void multiply()
    {
        // Grab the current contents of the first operand's field.
        final Integer num_a = get_num_a();
        if (null == num_a)
        {
            set_error();
            return;
        }

        // Grab the second operand from its field.
        final Integer num_b = get_num_b();
        if (null == num_b)
        {
            set_error();
            return;
        }

        int result = -1;

        try
        {
            result = Math.multiplyExact(num_a.intValue(), num_b.intValue());
        }
        catch (Exception e)
        {
            set_error();
            return;
        }

        // Set the result
        set_result(result);
    }

    // Wraps all action and behavior for divide button.
    private void divide()
    {
        // Grab the current contents of the first operand's field.
        final Integer num_a = get_num_a();
        if (null == num_a)
        {
            set_error();
            return;
        }

        // Grab the second operand from its field.
        final Integer num_b = get_num_b();
        if (null == num_b)
        {
            set_error();
            return;
        }

        if (0 == num_b)
        {
            set_error();
            return;
        }

        Log.v(TAG, "Divide " + String.valueOf(num_a) + " by " + String.valueOf(num_b));

        int result = -1;

        try
        {
            result = Math.floorDiv(num_a.intValue(), num_b.intValue());
        }
        catch (Exception e)
        {
            set_error();
            return;
        }

        // Set the result
        set_result(result);
    }

}
package com.example.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import androidx.appcompat.app.AppCompatActivity;

 import android.util.Log;
 import android.view.View;
 import android.widget.CheckBox;
 import android.widget.EditText;
 import android.widget.TextView;
 import android.widget.Toast;

 import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 1;
    int priceOfSingleCup =10;

    public void submitOrder(View view) {
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        EditText name_field = (EditText) findViewById(R.id.name);

        boolean hasWhippedCream = checkbox.isChecked();
        boolean hasChocolate = checkbox2.isChecked();
        String name = name_field.getText().toString();
        //Log.v("MainActivity","Has whipped cream : " + hasWhippedCream);

        int totalPrice = calculatePrice(hasWhippedCream,hasChocolate);
        String orderSummary = createOrderSummary(totalPrice,name,hasWhippedCream,hasChocolate);
        displayMessage(orderSummary);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void increment(View view) {
        if (quantity < 100) {
            quantity += 1;
            display(quantity);
        }
        else
        {
            Toast.makeText(this,"You cannot order more than 100 cups",Toast.LENGTH_LONG).show();
            return;
        }
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity -= 1;
            display(quantity);
        }
        else
        {
            Toast.makeText(this,"You cannot order less than 1 cups",Toast.LENGTH_LONG).show();
            return;
        }
    }

    public  int calculatePrice(boolean hasWhippedCream,boolean hasChocolate){
        int price = quantity*priceOfSingleCup;
        if(hasWhippedCream){
            price = price + 1;
        }
        if(hasChocolate){
            price = price + 2;
        }
        return price;
    }

    public String createOrderSummary(int totalPrice,String name,boolean hasWhippedCream,boolean hasChocolate) {
        String orderSummary = "Name: " + name +
                "\nQuantity: " + quantity + " Coffees" +
                "\nAdd whipped cream?" + hasWhippedCream +
                "\nAdd chocolate?" + hasChocolate +
                "\nTotal: $" + totalPrice +
                "\nThank You!";
        return orderSummary;
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

}

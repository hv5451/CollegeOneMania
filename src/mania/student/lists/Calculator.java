package mania.student.lists;


  
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
  
public class Calculator extends Activity implements OnClickListener {
  
   private EditText txtResult;  // Reference to EditText of result
   private int result = 0;      // Result of computation
   private String inStr = "0";  // Current input string
   // Previous operator: '+', '-', '*', '/', '=' or ' ' (no operator)
   private char lastOperator = ' ';
   
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.calculator);
      
      // Retrieve a reference to the EditText field for displaying the result.
      txtResult = (EditText)findViewById(R.id.txtResultId);
      txtResult.setText("0");
      
      // Register listener (this class) for all the buttons
      ((Button)findViewById(R.id.btnNum0Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum1Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum2Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum3Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum4Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum5Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum6Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum7Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum8Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnNum9Id)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnAddId)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnSubId)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnMulId)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnDivId)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnClearId)).setOnClickListener(this);
      ((Button)findViewById(R.id.btnEqualId)).setOnClickListener(this);
   }
  
   // On-click event handler for all the buttons
   public void onClick(View view) {
      switch (view.getId()) {
         // Number buttons: '0' to '9'
         case R.id.btnNum0Id:
         case R.id.btnNum1Id:
         case R.id.btnNum2Id:
         case R.id.btnNum3Id:
         case R.id.btnNum4Id:
         case R.id.btnNum5Id:
         case R.id.btnNum6Id:
         case R.id.btnNum7Id:
         case R.id.btnNum8Id:
         case R.id.btnNum9Id:
            String inDigit = ((Button)view).getText().toString(); 
            if (inStr.equals("0")) {  
               inStr = inDigit;    // no leading zero
            } else {
               inStr += inDigit;   // accumulate input digit
            }
            txtResult.setText(inStr);
            // Clear buffer if last operator is '='
            if (lastOperator == '=') {
               result = 0;
               lastOperator = ' ';
            }
            break;
            
         // Operator buttons: '+', '-', '*', '/' and '='
         case R.id.btnAddId:
            compute();
            lastOperator = '+';
            break;
         case R.id.btnSubId:
            compute();
            lastOperator = '-';
            break;
         case R.id.btnMulId:
            compute();
            lastOperator = '*';
            break;
         case R.id.btnDivId:
            compute();
            lastOperator = '/';
            break;
         case R.id.btnEqualId:
            compute();
            lastOperator = '=';
            break;
  
         // Clear button
         case R.id.btnClearId:   
            result = 0;
            inStr = "0";
            lastOperator = ' ';
            txtResult.setText("0");
            break;
      }
   }
   
   // User pushes '+', '-', '*', '/' or '=' button.
   // Perform computation on the previous result and the current input number,
   // based on the previous operator.
   private void compute() {
      int inNum = Integer.parseInt(inStr);
      inStr = "0";
      if (lastOperator == ' ') {
         result = inNum;
      } else if (lastOperator == '+') {
         result += inNum;
      } else if (lastOperator == '-') {
         result -= inNum;
      } else if (lastOperator == '*') {
         result *= inNum;
      } else if (lastOperator == '/') {
         result /= inNum;
      } else if (lastOperator == '=') {
         // Keep the result for the next operation
      }
      txtResult.setText(String.valueOf(result));
   }
}

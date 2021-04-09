package itescam.isc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String screen_text;
    private TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen_text = "";
        screen = (TextView) findViewById(R.id.text_screen);
    }

    public void buttonClick (View v) {
        Button buttonClicked = (Button) v;
        String textToAdd = "";
        switch (buttonClicked.getId()) {
            case R.id.b1:
                textToAdd = "1";
                break;
            case R.id.b2:
                textToAdd = "2";
                break;
            case R.id.b3:
                textToAdd = "3";
                break;
            case R.id.b4:
                textToAdd = "4";
                break;
            case R.id.b5:
                textToAdd = "5";
                break;
            case R.id.b6:
                textToAdd = "6";
                break;
            case R.id.b7:
                textToAdd = "7";
                break;
            case R.id.b8:
                textToAdd = "8";
                break;
            case R.id.b9:
                textToAdd = "9";
                break;
            case R.id.b0:
                textToAdd = "0";
                break;
            case R.id.bDividir:
                textToAdd = "/";
                break;
            case R.id.bMultiplicar:
                textToAdd = "*";
                break;
            case R.id.bSuma:
                textToAdd = "+";
                break;
            case R.id.bRestar:
                textToAdd = "-";
                break;
            case R.id.bPunto:
                textToAdd = ".";
                break;
            case R.id.bIgual:
                solveString();
                Toast.makeText(this, "Precione el resultado para reiniciar", Toast.LENGTH_SHORT).show();
                break;
        }
        screen_text += textToAdd;
        if (screen_text.contains("*") || screen_text.contains("+") || screen_text.contains("-") || screen_text.contains("/"))
            disableOperationsButtons(false);
        updateScreen();
    }

    private void solveString () {
        String c = "";
        if(screen_text.contains("*"))
            c = "\\*";
        if(screen_text.contains("-"))
            c = "-";
        if(screen_text.contains("+"))
            c = "\\+";
        if(screen_text.contains("/"))
            c = "/";
        String[] parts = screen_text.split(c);

        try {
            float a = Float.parseFloat(parts[0]);
            float b = Float.parseFloat(parts[1]);
            float r = 0;

            switch (c) {
                case "/":
                    r = a / b;
                    break;
                case "\\*":
                    r = a * b;
                    break;
                case "-":
                    r = a - b;
                    break;
                case "\\+":
                    r = a + b;
                    break;
            }
            screen_text = r + "";
            disableAllButtons(false);
        } catch (Exception e) {
            screen_text = "ERROR";
            disableAllButtons(false);
        }
        updateScreen();
    }

    private void disableOperationsButtons(Boolean value) {
        ((Button)findViewById(R.id.bSuma)).setEnabled(value);
        ((Button)findViewById(R.id.bRestar)).setEnabled(value);
        ((Button)findViewById(R.id.bMultiplicar)).setEnabled(value);
        ((Button)findViewById(R.id.bDividir)).setEnabled(value);
    }

    private void disableAllButtons (Boolean value) {
        ((Button)findViewById(R.id.bSuma)).setEnabled(value);
        ((Button)findViewById(R.id.bRestar)).setEnabled(value);
        ((Button)findViewById(R.id.bMultiplicar)).setEnabled(value);
        ((Button)findViewById(R.id.bDividir)).setEnabled(value);
        ((Button)findViewById(R.id.b1)).setEnabled(value);
        ((Button)findViewById(R.id.b2)).setEnabled(value);
        ((Button)findViewById(R.id.b3)).setEnabled(value);
        ((Button)findViewById(R.id.b4)).setEnabled(value);
        ((Button)findViewById(R.id.b5)).setEnabled(value);
        ((Button)findViewById(R.id.b6)).setEnabled(value);
        ((Button)findViewById(R.id.b7)).setEnabled(value);
        ((Button)findViewById(R.id.b8)).setEnabled(value);
        ((Button)findViewById(R.id.b9)).setEnabled(value);
        ((Button)findViewById(R.id.b0)).setEnabled(value);
        ((Button)findViewById(R.id.bPunto)).setEnabled(value);
        ((Button)findViewById(R.id.bIgual)).setEnabled(value);
    }

    public void resetScreen (View v) {
        screen_text = "";
        disableOperationsButtons(true);
        disableAllButtons(true);
        updateScreen();
    }

    private void updateScreen() {
        screen.setText(screen_text);
    }
}
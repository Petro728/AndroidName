package com.petryk.androidname;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AndroidNameActivity extends Activity {

    private EditText nameInput;
    private TextView resultText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        TextView header = new TextView(this);
        header.setText("Booted on: Android " + Build.VERSION.RELEASE 
                     + " (API " + Build.VERSION.SDK + ")\n");
        layout.addView(header);

        nameInput = new EditText(this);
        nameInput.setHint("Type any name here...");
        layout.addView(nameInput);

        Button checkButton = new Button(this);
        checkButton.setText("Find My Android Version");
        layout.addView(checkButton);

        resultText = new TextView(this);
        resultText.setPadding(0, 16, 0, 0);
        resultText.setText("Enter a name above and tap the button!");
        layout.addView(resultText);

        // Java 6 requires anonymous inner classes (no lambdas until Java 8)
        checkButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String typedName = nameInput.getText().toString().trim();
                if (typedName.length() == 0) {
                    resultText.setText("Please type a name first!");
                } else {
                    String codename = getCodename(typedName);
                    resultText.setText("User: " + typedName + "\n"
                                     + "Android Version Name: " + codename);
                }
            }
        });

        setContentView(layout);
    }

    private String getCodename(String name) {
        char initial = Character.toUpperCase(name.charAt(0));
        switch (initial) {
            case 'A': return "Astro Boy (Alpha)";
            case 'B': return "Bender (Beta)";
            case 'C': return "Cupcake (1.5)";
            case 'D': return "Donut (1.6)";
            case 'E': return "Eclair (2.0)";
            case 'F': return "Froyo (2.2)";
            case 'G': return "Gingerbread (2.3)";
            case 'H': return "Honeycomb (3.0)";
            case 'I': return "Ice Cream Sandwich (4.0)";
            case 'J': return "Jelly Bean (4.1)";
            case 'K': return "KitKat (4.4)";
            case 'L': return "Lollipop (5.0)";
            case 'M': return "Marshmallow (6.0)";
            case 'N': return "Nougat (7.0)";
            case 'O': return "Oreo (8.0)";
            case 'P': return "Pie (9.0)";
            case 'Q': return "Quince Tart (10)";
            case 'R': return "Red Velvet Cake (11)";
            case 'S': return "Snow Cone (12)";
            case 'T': return "Tiramisu (13)";
            case 'U': return "Upside Down Cake (14)";
            case 'V': return "Vanilla Ice Cream (15)";
            case 'W': return "Baklava / W (16+)";
            default:  return "Android " + initial;
        }
    }
}
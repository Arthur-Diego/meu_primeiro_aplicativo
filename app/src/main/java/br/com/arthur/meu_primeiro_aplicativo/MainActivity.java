package br.com.arthur.meu_primeiro_aplicativo;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText txtPeso;
    EditText txtAltura;
    Button btnCalcular;


    public void calculaImc() {

        String muitoAbaixoPeso = "Muito Abaixo do Peso!";
        String abaixoPeso = "Abaixo do Peso!";
        String pesoNormal = "Seu Peso está ideal!";
        String acimaDoPeso = "Você está acima do peso!";
        String obesidadeI = "Você está obeso!";
        String obesidadeII = "Você está com obesidade severa!";
        String obesidadeIII = "Cuidado obesidade mórbida!";

        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtAltura = (EditText) findViewById(R.id.txtAltura);

        double peso = Double.parseDouble(String.valueOf(txtPeso.getText()));
        double altura = Double.parseDouble(String.valueOf(txtAltura.getText()));

        double imc = peso / (altura * altura);
        DecimalFormat doubleImc = new DecimalFormat("0.###");
        String imcFormat = doubleImc.format(imc);

        if (imc < 17) {
            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setTitle("Resultado");
            diag.setMessage("IMC: " + imcFormat + ", " + muitoAbaixoPeso);
            diag.setNeutralButton("OK", null);
            diag.show();
        } else if (imc > 17 && imc < 18.49) {
            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setTitle("Resultado");
            diag.setMessage("IMC: " + imcFormat + ", " + abaixoPeso);
            diag.setNeutralButton("OK", null);
            diag.show();

        } else if (imc > 18.5 && imc < 24.99) {
            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setTitle("Resultado");
            diag.setMessage("IMC: " + imcFormat + ", " + pesoNormal);
            diag.setNeutralButton("OK", null);
            diag.show();
        } else if (imc > 25 && imc < 29.99) {
            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setTitle("Resultado");
            diag.setMessage("IMC: " + imcFormat + ", " + acimaDoPeso);
            diag.setNeutralButton("OK", null);
            diag.show();
        } else if (imc > 30 && imc < 34.99) {
            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setTitle("Resultado");
            diag.setMessage("IMC: " + imcFormat + ", " + obesidadeI);
            diag.setNeutralButton("OK", null);
            diag.show();
        } else if (imc > 35 && imc < 39.99) {
            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setTitle("Resultado");
            diag.setMessage("IMC: " + imcFormat + ", " + obesidadeII);
            diag.setNeutralButton("OK", null);
            diag.show();
        } else if (imc > 40) {
            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setTitle("Resultado");
            diag.setMessage("IMC: " + imcFormat + ", " + obesidadeIII+"!!!");
            diag.setNeutralButton("OK", null);
            diag.show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button) findViewById(R.id.btnStart);

        btnCalcular.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == btnCalcular.getId())
            this.calculaImc();
    }
}

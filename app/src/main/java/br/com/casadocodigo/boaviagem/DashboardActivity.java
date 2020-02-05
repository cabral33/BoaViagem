package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }

    public void selecionarGasto(View view){
        startActivity(new Intent(this, GastoActivity.class));
    }

    public void selecionarViagem(View view){
        switch (view.getId()){
            case R.id.nova_viagem:
                startActivity(new Intent(this, ViagemActivity.class));
                break;
        }
    }

    public void selecionarMinhasViagens(View view){
        startActivity(new Intent(this, ViagemListActivity.class));
    }

    public void selecionarConfigurar(View view){
        startActivity(new Intent(this, ConfiguracoesActivity.class));
    }





}



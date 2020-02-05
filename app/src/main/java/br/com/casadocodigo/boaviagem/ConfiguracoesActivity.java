package br.com.casadocodigo.boaviagem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class ConfiguracoesActivity extends PreferenceActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.xml.preferencias);

    }
}
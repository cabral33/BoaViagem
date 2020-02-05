package br.com.casadocodigo.boaviagem;

import android.app.ListActivity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GastoListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> gastos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] de = {"data", "descricao", "valor", "categoria"};
        int[] para = {R.id.data, R.id.descricao, R.id.valor, R.id.categoria};

        SimpleAdapter adapter = new SimpleAdapter(this, listarGastos(), R.layout.lista_gasto, de, para);

        adapter.setViewBinder(new GastoViewBinder());

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    private List<Map<String, Object>> listarGastos() {
        gastos = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("data", "04/02/2012");
        item.put("descricao", "Diária Hotel");
        item.put("valor", "R$ 260,00");
        item.put("categoria", R.color.categoria_hospedagem);
        gastos.add(item);

        return gastos;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String, Object> map = gastos.get(position);

        String descricao = (String) map.get("descricao");
        String mensagem = "Gasto selecionada: " + descricao;
        Toast.makeText(this, mensagem,Toast.LENGTH_SHORT).show();
    }

    private String dataAnterior = "";
    private class GastoViewBinder implements SimpleAdapter.ViewBinder {

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {
            if(view.getId() == R.id.data){
                if(!dataAnterior.equals(data)){
                    TextView textView = (TextView) view;
                    textView.setText(textRepresentation);
                    dataAnterior = textRepresentation;
                    view.setVisibility(View.VISIBLE);
                } else {
                    view.setVisibility(View.GONE);
                }
                return true;
            }
            if(view.getId() == R.id.categoria){
                Integer id = (Integer) data;
                view.setBackgroundColor(getResources().getColor(id));
                return true;
            }
            return false;
        }
    }

}




//    @Override
//    public void onItemClick (AdapterView <?> parent, View view, int position, long id) {
//        TextView textView = (TextView) view;
//        Toast.makeText(this,"Gasto selecionado: " + textView, Toast.LENGTH_SHORT).show();
//    }
//
//    private List <String> listarSaoPaulo() {
//        return Arrays.asList("Sanduíche R$ 19,90",
//                "Táxi Aeroporto - Hotel R$ 34,00",
//                "Revista R$ 12,00");
//    }
//
//    private List <String> listarManaus(){
//        return Arrays.asList("Sanduíche R$ 4,00",
//                "Táxi Aeroporto - Hotel R$ 50,00",
//                "Revista R$ 5,00");
//    }
//
//    private List <String> listaRio(){
//        return Arrays.asList("Sanduíche R$ 100,00",
//                "Táxi Aeroporto - Hotel R$ 100,00",
//                "Revista R$ 100,00");
//    }
//
//}
//
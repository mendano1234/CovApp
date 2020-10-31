package men.dat.appapi.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import men.dat.appapi.API.APIClient;
import men.dat.appapi.Model.Mundial;
import com.example.covapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    TextView mcasos, mmuertes, mrecuperados;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mcasos  = root.findViewById(R.id.casosTv);
        mmuertes = root.findViewById(R.id.muertosTv);
        mrecuperados = root.findViewById(R.id.recuperadosTv);


        obtenerdatos();
        return root;
    }
    private void obtenerdatos(){
        Call<Mundial> call = APIClient.getInstance().getApi().getInfoMundial();
        call.enqueue(new Callback<Mundial>() {
            @Override
            public void onResponse(Call<Mundial> call, Response<Mundial> response) {
                Mundial datos=response.body();
                mcasos.setText(datos.getCases());
                mmuertes.setText(datos.getDeaths());
                mrecuperados.setText(datos.getRecovered());

            }

            @Override
            public void onFailure(Call<Mundial> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });
    }
}
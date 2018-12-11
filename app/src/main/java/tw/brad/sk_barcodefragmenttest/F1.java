package tw.brad.sk_barcodefragmenttest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class F1 extends Fragment {
    private TextView txt;
    private Button btn;
    private View mainView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mainView == null) {
            mainView = inflater.inflate(
                    R.layout.fragment_f1, container, false);
            txt = mainView.findViewById(R.id.f1_txt);
            btn = mainView.findViewById(R.id.f1_btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showLottery();
                }
            });
        }
        return mainView;
    }

    private void showLottery(){
        int lottery = (int)(Math.random()*49+1);
        txt.setText("" + lottery);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}

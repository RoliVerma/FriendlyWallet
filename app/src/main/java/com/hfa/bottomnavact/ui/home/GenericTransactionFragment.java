package com.hfa.bottomnavact.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.hfa.bottomnavact.R;

public class GenericTransactionFragment extends Fragment {
    EditText money,reason;
    Button saveBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.generic_transaction,container,false);
         money = view.findViewById(R.id.editMoney);
         reason = view.findViewById(R.id.editReason);
        saveBtn = view.findViewById(R.id.SaveBtn);

        if(savedInstanceState!=null){
            money.setText(savedInstanceState.getInt("money_key"));
            reason.setText(savedInstanceState.getInt("reason_key"));
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_genericTransactionFragment_to_navigation_dashboard);
            }
        });
        return view;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        int moneyInt = Integer.parseInt(money.getText().toString());
        String reasonStr = reason.getText().toString();
        outState.putInt("money_key",moneyInt);
        outState.putCharSequence("reason_key",reasonStr);
    }


}

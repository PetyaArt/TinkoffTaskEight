package com.example.petya.tinkofftaskeight;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText mEditTextParent;
    private EditText mEditTextChild;

    private ExampleDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);

        builder.setView(view)
                .setTitle("relationship")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String parent = mEditTextParent.getText().toString();
                        String child = mEditTextChild.getText().toString();
                        mListener.applyTexts(parent, child);
                    }
                });

        mEditTextParent = view.findViewById(R.id.edit_parent);
        mEditTextChild = view.findViewById(R.id.edit_child);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (ExampleDialogListener) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String parent, String child);
    }
}

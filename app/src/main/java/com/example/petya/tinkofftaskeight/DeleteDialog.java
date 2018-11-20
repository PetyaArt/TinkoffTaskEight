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

public class DeleteDialog extends AppCompatDialogFragment {

    private EditText mEditTextDelete;

    private DeleteDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.delete_dialog, null);

        builder.setView(view)
                .setTitle("delete")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String deleteId = mEditTextDelete.getText().toString();
                        mListener.delete(deleteId);
                    }
                });

        mEditTextDelete = view.findViewById(R.id.delete_id);

        return builder.create();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (DeleteDialogListener) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface DeleteDialogListener {
        void delete(String id);
    }
}

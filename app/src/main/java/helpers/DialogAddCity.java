package helpers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.skender.weatherapp.MainActivity;
import com.example.skender.weatherapp.R;

import java.util.ArrayList;

import database.BuilderDB;
import Interfaces.IDataBaseApi;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

/**
 * Created by skender on 19.04.18.
 */

public class DialogAddCity {

    public static final String ADD_CITY_TITLE = "Добавьте город";
    public static final String NAME_POSITIVE_BUTTON = "Сохранить";
    public static final String NAME_NEGATIVE_BUTTON = "Отмена";

    private Context context;
    private String Title;
    private String namePositiveButton;
    private String nameNegativeButton;
    private IDataBaseApi roomDataBase;
    private Activity activity;

    public DialogAddCity(Context contextMain,
                         String title,
                         String namePositiveButton,
                         String nameNegativeButton,
                         IDataBaseApi roomDataBase,
                         Activity activity){
        this.context = contextMain;
        this.Title = title;
        this.namePositiveButton = namePositiveButton;
        this.nameNegativeButton = nameNegativeButton;
        this.roomDataBase = roomDataBase;
        this.activity = activity;
    }

    public void createDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        @SuppressLint("inflateParams")
        View dialogView =
                layoutInflater.inflate(R.layout.dialog_add_city_layout, null);

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setTitle(Title);

        alertBuilder.setIcon(R.drawable.android_weather);
        alertBuilder.setView(dialogView);
        final EditText nameCity = dialogView.findViewById(R.id.et_input);
        alertBuilder
                .setCancelable(false)
                .setPositiveButton(namePositiveButton,
                        (dialog, id) -> {
                            BuilderDB builderDB = new BuilderDB();
                            builderDB.set_nameCity(nameCity.getText().toString());
                            roomDataBase.addEntry(builderDB);
                            activity.recreate();
                        })
                .setNegativeButton(nameNegativeButton,
                        ((dialogInterface, i) -> dialogInterface.cancel()));
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }


}

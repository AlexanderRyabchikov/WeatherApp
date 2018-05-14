package helpers;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.skender.weatherapp.R;

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

    //private RoomDataBase roomDataBase;

    public DialogAddCity(Context contextMain,
                         String title,
                         String namePositiveButton,
                         String nameNegativeButton
                         /*RoomDataBase roomDataBase*/){
        this.context = contextMain;
        this.Title = title;
        this.namePositiveButton = namePositiveButton;
        this.nameNegativeButton = nameNegativeButton;
        /*this.roomDataBase = roomDataBase;*/
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
                            /**
                             *  TODO Реализация проверки поля
                             *  Запись данных в базу
                             * */
                            System.out.println("test");
                        })
                .setNegativeButton(nameNegativeButton,
                        ((dialogInterface, i) -> dialogInterface.cancel()));
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }

}

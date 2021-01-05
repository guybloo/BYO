package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.byo.DB.ByoDB;
import com.example.byo.DB.DBItem;
import com.example.byo.DB.DBWrapper;
import com.example.byo.DB.EventDB;
import com.example.byo.Displays.ByoDisplay;
import com.example.byo.Types.Byo;
import com.example.byo.Types.CurrentUser;
import com.example.byo.Types.Event;
import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateEvent extends AppCompatActivity {

    private Event event;
    private Date tempDate;
    private List<Byo> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        final Context context = this;

        if(!getIntent().getBooleanExtra(CreateByo.EDIT,true))
        {
            hideEdit();
        }
        items = new ArrayList<>();
        event = (Event) getIntent().getSerializableExtra(Event.SER_LABEL);
        if (event == null) {
            event = new Event();
            event.setOwnerID(CurrentUser.getEmail());
        } else {
            loadEvent();
            tempDate = event.getDateTime();
        }
        findViewById(R.id.btn_save_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEvent();
                (new EventDB()).updateItem(event);
                finish();
            }
        });

        findViewById(R.id.btn_delete_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new EventDB()).removeItem(event.getId());
                finish();
            }
        });

        findViewById(R.id.create_event_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SingleDateAndTimePickerDialog.Builder(context)
                        //.bottomSheet()
                        //.curved()
                        //.stepSizeMinutes(15)
                        //.displayHours(false)
                        //.displayMinutes(false)
                        //.todayText("aujourd'hui")
                        .displayListener(new SingleDateAndTimePickerDialog.DisplayListener() {
                            @Override
                            public void onDisplayed(SingleDateAndTimePicker picker) {
                                // Retrieve the SingleDateAndTimePicker
                            }
                        })
                        .title("Simple")
                        .listener(new SingleDateAndTimePickerDialog.Listener() {
                            @Override
                            public void onDateSelected(java.util.Date date) {
                                tempDate = new Date(date.getTime());
                                ((TextView) findViewById(R.id.create_event_date)).setText(formatDate(tempDate));
                            }

                        }).display();
            }
        });

        findViewById(R.id.create_event_add_byo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openByoChoose(context, event);
            }
        });
    }

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        return formatter.format(date);
    }

    private void updateEvent() {
        event.setTitle(((TextView) findViewById(R.id.create_event_title_text)).getText().toString());
        event.setDateTime(tempDate);
        event.setDescription(((TextView) findViewById(R.id.create_event_description_text)).getText().toString());
    }

    private void loadEvent() {
        ((EditText) findViewById(R.id.create_event_title_text)).setText(event.getTitle());
        ((TextView) findViewById(R.id.create_event_date)).setText(formatDate(event.getDateTime()));
        ((EditText) findViewById(R.id.create_event_description_text)).setText(event.getDescription());
        final ByoDB byoDB = new ByoDB();
        final Context context = this;
        final LinearLayout layout = findViewById(R.id.create_event_byo_list);

        if (event.getServiceIDs().size() > 0) {
            byoDB.loadItemsByListFieldFromDB(DBWrapper.ID, event.getServiceIDs());
            byoDB.setDataChangeListener(new DBWrapper.OnDataChangeListener() {
                @Override
                public void onGetAll() {

                }

                @Override
                public void onGetSpecific() {
                    for (DBItem item : byoDB.getItems().values()) {
                        items.add((Byo) item);
                        ByoDisplay display = new ByoDisplay((Byo) item, context, false, layout);
                        display.addView(layout);
                    }
                }
            });
        }

    }

    private void hideEdit(){
        findViewById(R.id.create_event_description_text).setEnabled(false);
        findViewById(R.id.create_event_title_text).setEnabled(false);
        findViewById(R.id.create_event_date).setEnabled(false);
        findViewById(R.id.create_event_add_byo).setVisibility(View.GONE);
        findViewById(R.id.create_event_btns).setVisibility(View.GONE);

    }
    @Override
    protected void onResume() {
        super.onResume();
//        loadEvent();
    }
}
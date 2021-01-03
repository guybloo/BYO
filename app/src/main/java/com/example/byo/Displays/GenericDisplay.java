package com.example.byo.Displays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.byo.DB.DBItem;
import com.example.byo.Navigation;
import com.example.byo.R;
import com.example.byo.Types.Byo;

/**
 * shows user details in group
 */
public class GenericDisplay {
    // user is the one who sees this page, other user is another group member to show
    protected DBItem item;
    protected RelativeLayout.LayoutParams params;
    protected View view;
    protected LinearLayout parent;
    protected Context context;
    protected AlertDialog.Builder openDetails;
    protected AlertDialog dialog;
    protected onDeleteListener listener;

    public GenericDisplay(DBItem item, final Context context, int displayID){
        this.context = context;
        this.item = item;
        params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        view = ((Activity)context).getLayoutInflater().inflate(displayID, null);

        updateUI();
    }

    public void updateUI(){}

//    /**
//     * sets the images size
//     * @param size the wanted size
//     */
//    public void setImageSize(int size){
//        ImageView image = view.findViewById(R.id.user_display_image);
//
//       image.getLayoutParams().height = size;
//       image.getLayoutParams().width = size;
//    }

    /**
     * event interface
     */
    public interface onDeleteListener {
        void onDelete(DBItem item);
    }

    /**
     * sets the listener
     * @param listener
     */
    public void setOnDeleteListener(GenericDisplay.onDeleteListener listener) {
        this.listener = listener;
    }

    /**
     * gets the view
     * @return the specific view layout
     */
    public View getView() {
        return view;
    }

//    /**
//     * sets margin params
//     * @param left from left
//     * @param top from top
//     */
//    public void setParams(int left, int top) {
//        this.params.leftMargin = left;
//        this.params.topMargin = top;
//    }

    /**
     * gets the layout params
     * @return
     */
    public RelativeLayout.LayoutParams getParams() {
        return params;
    }

    /**
     * adds the view to the layout
     * @param layout
     */
    public void addView(LinearLayout layout){
        if(parent == null) {
            parent = layout;
            parent.addView(view, params);
        }
    }

    /**
     * remove this view from the layout
     */
    public void removeView(){
        ((ViewGroup) parent).removeView(view);
        parent = null;
    }

//    /**
//     * updates the user details in the view
//     */
//    public void updateUserDetails()
//    {
//        ImagesDB.showCircleImage(otherUser.getImageUrl(),(ImageView)view.findViewById(R.id.user_display_image),context);
//        openDetails = new AlertDialog.Builder(context);
//        View detailsView = ((Activity)context).getLayoutInflater().inflate(R.layout.request_view, null);
//
//        GridLayout fearsLayout = detailsView.findViewById(R.id.request_fears);
//        GridLayout skillsLayout = detailsView.findViewById(R.id.request_skills);
//        GridDisplay gridDisplay = new GridDisplay(context,user, fearsLayout, skillsLayout, false, 6);
//
//        detailsView.findViewById(R.id.request_approve).setVisibility(View.GONE);
//        if(!user.getId().equals(group.getId())){
//            detailsView.findViewById(R.id.request_delete).setVisibility(View.GONE);
//        }
//        else{
//            ((Button)detailsView.findViewById(R.id.request_delete)).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (listener != null) {
//                        listener.onDelete(otherUser);
//                        dialog.dismiss();
//                    }
//                }
//            });
//        }
//
//        ((TextView)detailsView.findViewById(R.id.request_nick_name)).setText(otherUser.getNickName());
//        ((TextView)detailsView.findViewById(R.id.request_phone)).setText(otherUser.getPhone());
//        ((TextView)detailsView.findViewById(R.id.request_email)).setText(otherUser.getEmail());
//
//        ImagesDB.showCircleImage(otherUser.getImageUrl(),(ImageView)detailsView.findViewById(R.id.request_image),context);
////        openDetails.setMessage("Are You Sure to delete?");
//        openDetails.setView(detailsView);
//        dialog = openDetails.create();
//    }
}

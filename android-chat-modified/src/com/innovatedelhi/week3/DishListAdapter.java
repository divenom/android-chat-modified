package com.innovatedelhi.week3;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Query;

/**
 * User: Divyanshu
 * Date: 9/18/14
 * Time: 12:33 PM
 */

/**
 * This class is an example of how to use FirebaseListAdapter. It uses the <code>Chat</code> class to encapsulate the
 * data for each individual chat message
 */
public class DishListAdapter extends FirebaseListAdapter<Dish> {

    // The username for this client. We use this to indicate which messages originated from this user
    private String username;

    public DishListAdapter(Query ref, Activity activity, int layout, String username) {
        super(ref, Dish.class, layout, activity);
        this.username = username;
    }

    /**
     * Bind an instance of the <code>Chat</code> class to our view. This method is called by <code>FirebaseListAdapter</code>
     * when there is a data change, and we are given an instance of a View that corresponds to the layout that we passed
     * to the constructor, as well as a single <code>Chat</code> instance that represents the current data to bind.
     * @param view A view instance corresponding to the layout we passed to the constructor.
     * @param dish An instance representing the current state of a chat message
     */
    @Override
    protected void populateView(View view, Dish dish) {
    	
    	//((ImageView)view.findViewById(R.id.dish_image)).setBackground(dish.getPhoto());
    	
    	// Loader image - will be shown before loading image
        int loader = R.drawable.loader;
         
        // Imageview to show
        ImageView image = (ImageView)view.findViewById(R.id.dish_image);
         
        // Image url
        String image_url = dish.getPhoto();
         
        // ImageLoader class instance
        ImageLoader imgLoader = new ImageLoader(view.getContext());
         
        // whenever you want to load an image from url
        // call DisplayImage function
        // url - image url to load
        // loader - loader image, will be displayed before getting image
        // image - ImageView 
        imgLoader.DisplayImage(image_url, loader, image);    	
    	
    	
/*    	
 * Syntax:
 * 
 * imgLoader.DisplayImage(image_url, loader, image);
    	 image_url - is image url path
    	 loader - loader image, will be shown before loading image
    	 image - is ImageView
*/    	
    	
        // Map a Chat object to an entry in our listview
        String name = dish.getName();
        TextView authorText = (TextView)view.findViewById(R.id.name);
        authorText.setText(name + ": ");
        // If the message was sent by this user, color it differently
        if (name.equals(username)) {
            authorText.setTextColor(Color.RED);
        } else {
            authorText.setTextColor(Color.BLUE);
        }
        ((TextView)view.findViewById(R.id.price)).setText(dish.getPrice());
        ((TextView)view.findViewById(R.id.description)).setText(dish.getDescription());
    }
}

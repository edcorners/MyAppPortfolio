package com.portfolio.edison.myappportfolio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        FragmentActivity context = getActivity();
        int colorPrimaryLight = ContextCompat.getColor(context, R.color.colorPrimaryLight); // Using ContextCompat to be able to retrieve color in older than M versions http://stackoverflow.com/questions/31842983/getresources-getcolor-is-deprecated
        int colorAccent = ContextCompat.getColor(context, R.color.colorAccent); // As suggested at http://stackoverflow.com/questions/31842983/getresources-getcolor-is-deprecated
        int colorWhite = ContextCompat.getColor(context, R.color.colorWhite);
        int colorBlack = ContextCompat.getColor(context, R.color.colorBlack);

        styleSpotifyButton(rootView, colorPrimaryLight, colorBlack);
        styleScoresButton(rootView, colorPrimaryLight, colorBlack);
        styleLibraryButton(rootView, colorPrimaryLight, colorBlack);
        styleBIBButton(rootView, colorPrimaryLight, colorBlack);
        styleXYZReaderButton(rootView, colorPrimaryLight, colorBlack);
        styleCapstoneButton(rootView, colorAccent, colorWhite);

        return rootView;

    }

    private void styleCapstoneButton(View context, int bgColor, int textColor) {
        AppCompatButton capstone = (AppCompatButton) context.findViewById(R.id.buttonCapstoneMyapp);
        CharSequence capstoneToast = "This button will launch my Capstone app!";
        applyPropertiesToButton(bgColor, textColor, capstoneToast, capstone);
    }

    private void styleXYZReaderButton(View context, int bgColor, int textColor) {
        AppCompatButton xYZReader = (AppCompatButton) context.findViewById(R.id.buttonXYZReader);
        CharSequence xYZReaderToast = "This button will launch my XYZ Reader app!";
        applyPropertiesToButton(bgColor, textColor, xYZReaderToast, xYZReader);
    }

    private void styleBIBButton(View context, int bgColor, int textColor) {
        AppCompatButton buildItBigger = (AppCompatButton) context.findViewById(R.id.buttonBuildItBigger);
        CharSequence buildItBiggerToast = "This button will launch my Build It Bigger app!";
        applyPropertiesToButton(bgColor, textColor, buildItBiggerToast, buildItBigger);
    }

    private void styleLibraryButton(View context, int bgColor, int textColor) {
        AppCompatButton library = (AppCompatButton) context.findViewById(R.id.buttonLibraryApp);
        CharSequence libraryToast = "This button will launch my Library app!";
        applyPropertiesToButton(bgColor, textColor, libraryToast, library);
    }

    private void styleScoresButton(View context, int bgColor, int textColor) {
        AppCompatButton scores = (AppCompatButton) context.findViewById(R.id.buttonScoresApp);
        CharSequence scoresToast = "This button will launch my Scores app!";
        applyPropertiesToButton(bgColor, textColor, scoresToast, scores);
    }

    private void styleSpotifyButton(View context, int backgroundColor, int textColor) {
        AppCompatButton spotifyButton = (AppCompatButton) context.findViewById(R.id.buttonSpotifyStreamer); // Using AppCompatButton to be able to background tint in older than M versions
        CharSequence spotifyToast = "This button will launch my Spotify app!";
        applyPropertiesToButton(backgroundColor, textColor, spotifyToast, spotifyButton);
    }

    private void applyPropertiesToButton(int backgroundColor, int textColor, final CharSequence toastText, AppCompatButton button) {
        button.setSupportBackgroundTintList(ColorStateList.valueOf(backgroundColor));
        button.setTextColor(textColor);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                displayToast(toastText);
            }
        });
    }

    private void displayToast(CharSequence text) {// as in http://developer.android.com/guide/topics/ui/notifiers/toasts.html
        Context context = getActivity();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

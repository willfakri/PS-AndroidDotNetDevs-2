package com.pluralsight.withresult;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
  static final int PROVIDE_INFO_REQUEST_CODE = 1000;
  static final int TAKE_PICTURE_REQUEST_CODE = 1010;

  // <editor-fold desc="view field getters">

  public TextView getClassNameTextView() {
    if (mClassNameTextView == null)
      mClassNameTextView = (TextView) findViewById(R.id.classNameTextView);
    return mClassNameTextView;
  }

  public TextView getPersonNameTextView() {
    if (mPersonNameTextView == null)
      mPersonNameTextView = (TextView) findViewById(R.id.personNameTextView);
    return mPersonNameTextView;
  }

  public TextView getEmailTextView() {
    if (mEmailTextView == null)
      mEmailTextView = (TextView) findViewById(R.id.emailTextView);
    return mEmailTextView;
  }

  public ImageView getThumbNailImageView() {
    if (mThumbNailImageView == null)
      mThumbNailImageView = (ImageView) findViewById(R.id.thumbnailImageview);
    return mThumbNailImageView;
  }

  // </editor-fold>

  // <editor-fold desc="private view fields - Access Only Through Getters">

  TextView mClassNameTextView;
  TextView mPersonNameTextView;
  TextView mEmailTextView;
  ImageView mThumbNailImageView;

  // </editor-fold>

  Uri mPhotoPathUri;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setupViews();
  }

  private void setupViews() {
    Button moreInformationButton = (Button) findViewById(R.id.provideInfoButton);
    moreInformationButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        handleMoreInformationButton((Button) view);
      }
    });

    Button takePictureButton = (Button) findViewById(R.id.takePictureButton);
    takePictureButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        handleTakePictureButton((Button) view);
      }
    });

    Button sendButton = (Button) findViewById(R.id.sendtButton);
    sendButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        handleSendButton((Button) view);
      }
    });

  }

  void handleMoreInformationButton(Button button) {

  }

  void handleTakePictureButton(Button button) {
    mPhotoPathUri = PhotoHelper.generateTimeStampPhotoFileUri();

  }

  void handleSendButton(Button button) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(getString(R.string.send_dialog_title));
    builder.setMessage(getString(R.string.send_dialog_message));
    builder.setIcon(R.drawable.ic_launcher);
    builder.setCancelable(false);
    builder.setPositiveButton(getString(R.string.send_dialog_positive_button), new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {
        handleSendConfirmation(dialogInterface, i);
      }
    });

    builder.setNegativeButton(getString(R.string.send_dialog_negative_button), new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {
        handleSendConfirmation(dialogInterface, i);
      }
    });

    AlertDialog alertDialog = builder.create();
    alertDialog.show();
  }

  void handleSendConfirmation(DialogInterface dialog, int buttonId) {
    dialog.dismiss();
    if (buttonId == DialogInterface.BUTTON_POSITIVE) {
      doTransfer();
    }
  }

  void doTransfer() {
    String classNameToSend = (String) getClassNameTextView().getText();
    String personNameToSend = (String) getPersonNameTextView().getText();
    String emailToSend = (String) getEmailTextView().getText();
    String photoPathName = mPhotoPathUri.getPath();

    // Pretend to send values to wherever they are supposed to go
    Toast.makeText(this, "Transferring", Toast.LENGTH_LONG).show();
  }
}

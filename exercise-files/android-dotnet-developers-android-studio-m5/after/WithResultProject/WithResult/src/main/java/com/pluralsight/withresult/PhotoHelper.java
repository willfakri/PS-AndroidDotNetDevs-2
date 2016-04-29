package com.pluralsight.withresult;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jim on 6/21/13.
 */
public class PhotoHelper {
  private static final String LOG_TAG = "PHOTO HELPER";

  /**
   * Create a pathname composed of the current time appropriate for storing
   * a photo. The location of the file is a subfolder named "Pluralsight"
   * within the appropriate folder for storing pictures for the current user
   * @return The full path to the file
   */
  public static Uri generateTimeStampPhotoFileUri() {
    Uri photoFileUri = null;

    // Request the path to the Pluralsight folder in the photo folder
    File outputDir = getPhotoDirectory();

    if (outputDir != null) {
      // Create a file name for the photo based on current date/time
      String timeStamp = new SimpleDateFormat("yyyyMMDD_HHmmss").format(new Date());
      String photoFileName = "IMG_" + timeStamp + ".jpg";

      // Create File instance representing the photo file within th
      //  the Plurasight subfolder of the photos folder
      File photoFile = new File(outputDir, photoFileName);
      // Convert the File path to a URI
      photoFileUri = Uri.fromFile(photoFile);
    }


    return photoFileUri;
  }

  /**
   * The path to the "Pluralsight" subfolder within the appropriate folder
   * for storing photos for the current user. Assures that the external media
   * is mounted and creates the "Pluralsight" subfolder if it doesn't already
   * exist.
   * @return Path to the "Pluralsight" subfolder within the appropriate folder
   * for storing photos for this user
   */
  public static File getPhotoDirectory() {
    File outputDir = null;

    // Confirm that External Storage (SD Card) is mounted
    String externalStorageState = Environment.getExternalStorageState();
    if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {

      // Request the Folder where photos are supposed to be stored
      File pictureDir =
          Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

      // Create a subfolder named Pluralsight
      outputDir = new File(pictureDir, "Pluralsight");
      if (!outputDir.exists()) {
        if (!outputDir.mkdirs()) {
          Log.e(LOG_TAG, "Failed to create directory: " + outputDir.getAbsolutePath());
          outputDir = null;
        }
      }
    }

    return outputDir;
  }

  /**
   * Adds the photo file to the MediaStore and displays it's thummbnail within the
   * passed ImageView
   * @param pathName Path to the photo file
   * @param activity Activity that contains the ImageView
   * @param imageView ImageView in which to display the thumbnail
   */
  public static void addPhotoToMediaStoreAndDisplayThumbnail(String pathName, Activity activity, ImageView imageView) {
    // Create final references so they can be passed in a cloujure to the callbacks
    final ImageView thumbnailImageView = imageView;
    final Activity thumbnailActivity = activity;

    String[] filesToScan = {pathName};

    // Request Media Scanner to add photo into the Media system
    MediaScannerConnection.scanFile(thumbnailActivity, filesToScan, null,
        new MediaScannerConnection.OnScanCompletedListener() {
          public void onScanCompleted(String filePath, Uri uri) {
            // The MediaStore calls back into this method to let us know
            //  the scan is complete - this call occurs on a non-UI thread
            long id = ContentUris.parseId(uri);
            ContentResolver contentResolver = thumbnailActivity.getContentResolver();

            // Request a thumbnail of the picture from the MediaStore
            final Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(
                contentResolver, id, MediaStore.Images.Thumbnails.MINI_KIND, null);

            // Load the thumbnail into the imageview
            // This call must occur on the UI thread
            thumbnailActivity.runOnUiThread(new Runnable() {
              @Override
              public void run() {
                thumbnailImageView.setImageBitmap(thumbnail);
              }
            });
           }
        });

  }

}

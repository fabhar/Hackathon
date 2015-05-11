/**
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.materialise.hackandroid.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.materialise.hackandroid.R;

/**
 * Created by fabhar on 5/11/15.
 */
public class BaseActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        // When: Called when the activity is first created
        // Common Base UI initialisation: ActionBar, SnackBar, device Orientation...
        // On Subclass Activity, it should handle UI boilerplate initialisation/binding,
        // i.e. createcontentview, findviewbyid
    }

    @Override
    public void onResume() {
        super.onResume();

        // When: When Activity start interacting with User
        // Handle Common action when user are expected to interact with the Activity
        // i.e. Internet connectivity checker/warning message
        // On Subclass Activity, it should begin GPS Scanning, begin Animations, camera, etc

        // Let the user know when they are not connected to the internet
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if ((ni == null) || (!ni.isConnected())) {
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.device_offline_message),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        // When: Activity is going background, but not (yet) being killed
        // On Subclass, it this is useful when managing resource before another activity is started
        // i.e. stopping animation, camera
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // When: Called before activity being killed
        // Save outState data before it is killed so that it can be retrieved onCreate or
        // onRestoreInstanceState
    }

}

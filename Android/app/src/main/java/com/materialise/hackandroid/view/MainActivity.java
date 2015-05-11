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

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.materialise.hackandroid.R;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends BaseActivity {

    private ArrayList<String> mUrls = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUrls = new ArrayList<String>(){{
            // Picture are copyright of its original author.
            // No claim was made on the authorship when it is embedded in the APP.
            // Pictures are used for demonstration purpose only.

            add("http://www.maximumpc.com/files/android_rock.png");
            add("http://www.guitarthai.com/picpost/gtpicpost/Q367224.jpg");
            add("http://newrock1049x.com/wp-content/uploads/2014/10/android-rock.jpg");
            add("http://rockbandaide.com/wp-content/uploads/2010/10/AndroidRB.jpg");
            add("http://kara.allthingsd.com/files/2011/02/Sonos_Android_RockBand_White_FINAL.jpg");
            add("http://www.wallpaper4me.com/images/wallpapers/android_skeleton_w1.jpeg");
        }};

        switchFragment();

        Button btnClickMe = (Button)findViewById(R.id.btn_pressme);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });
    }

    public void switchFragment() {
        Random rand = new Random();
        int choice = rand.nextInt(mUrls.size());

        Bundle args = new Bundle();
        args.putString("url", mUrls.get(choice));

        PictureFragment picFragment = new PictureFragment();
        picFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out);
        transaction.replace(R.id.fl_fragplaceholder, picFragment).commit();
    }
}

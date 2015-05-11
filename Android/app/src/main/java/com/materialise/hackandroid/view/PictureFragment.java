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
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialise.hackandroid.R;
import com.squareup.picasso.Picasso;

/**
 * Created by fabhar on 5/11/15.
 */
public class PictureFragment extends Fragment {

    private String mImageUrl;

    public PictureFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();

        if (arguments == null) {
            arguments = new Bundle();
        }

        mImageUrl = arguments.getString("url");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_picture, container, false);

        ImageView ivImage = (ImageView) view.findViewById(R.id.iv_fragpic);
        Picasso.with(getActivity().getApplicationContext()).
                load(mImageUrl).into(ivImage);

        TextView tvImgUrl = (TextView) view.findViewById(R.id.tv_fragurl);
        tvImgUrl.setText(mImageUrl);

        return view;
    }
}

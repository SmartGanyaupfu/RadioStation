package za.co.smartdevops.smart.kayaapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by smart on 4/30/2018.
 */

public interface RetrofitArrayApi {

    @GET("wp-json/wp/v2/posts")
    Call<List<WPPost>>getPostInfo();

}

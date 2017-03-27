package ph.com.bilinear.ccf_mobile.data.remote;

import ph.com.bilinear.ccf_mobile.data.vo.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jtampinco on 3/21/2017.
 */

public interface NewsService {

    @GET("/news/{id}")
    Call<News> getNewsfeedItem(@Path("id") int id);

}

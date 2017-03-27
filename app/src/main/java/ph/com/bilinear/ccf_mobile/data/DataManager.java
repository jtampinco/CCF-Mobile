package ph.com.bilinear.ccf_mobile.data;

import ph.com.bilinear.ccf_mobile.core.Constants;
import ph.com.bilinear.ccf_mobile.data.remote.NewsService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jtampinco on 3/21/2017.
 */

public class DataManager {

    private NewsService mNewsService;

    public NewsService getNewsService(){
        if(mNewsService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mNewsService = retrofit.create(NewsService.class);

        }

        return mNewsService;
    }

}

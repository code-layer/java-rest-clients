package in.datalayer.sample2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StackOverflowService {

    private static StackOverflowAPI api;

    public static synchronized StackOverflowAPI getStackOverflowAPI() {
        if (api == null) {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(StackOverflowAPI.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();

            api = retrofit.create(StackOverflowAPI.class);
        }
        return api;

    }

}
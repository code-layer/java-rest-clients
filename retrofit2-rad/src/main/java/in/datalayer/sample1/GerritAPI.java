package in.datalayer.sample1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface GerritAPI {

    @GET("changes/")
    Call<List<Change>> loadChanges(@Query("q") String status);

}

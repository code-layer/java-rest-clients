package in.datalayer.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AyncTest {
	public static void main(String[] args) {
		  OkHttpClient client = new OkHttpClient();
		  Request request = new Request.Builder()
				.url("http://publicobject.com/helloworld.txt")
		        .build();

		  client.newCall(request).enqueue(new Callback() {
		      @Override
			  public void onFailure(Call call, IOException e) {
				  e.printStackTrace();
		      }

		      @Override
			  public void onResponse(Call call, Response response) throws IOException {
		        try (ResponseBody responseBody = response.body()) {
		          if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
		          Headers responseHeaders = response.headers();
		          for (int i = 0, size = responseHeaders.size(); i < size; i++) {
		            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
		          }
		          System.out.println(responseBody.string());
		        }
		      }
		  });
	}
}